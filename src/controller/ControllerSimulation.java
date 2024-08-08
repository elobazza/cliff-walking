package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import model.Actions;
import model.AgentWalker;
import model.PathCell;
import model.SimulationMap;
import observer.InterfaceControllerObserved;
import observer.InterfaceViewObserver;
import view.tablemodel.TableModelMap;

/**
 * Simulation Controller Class
 * @author Eloisa Bazzanella
 */
public class ControllerSimulation implements InterfaceControllerObserved {
    
    private SimulationMap simulationMap;
    private AgentWalker   agentWalker;
    private boolean       start = true;
    
    private File arquivo;
    private final ArrayList<InterfaceViewObserver> observers;
    private static ControllerSimulation instance = null;
    
    private double learningRate;
    private double discountFactor;
    private double epsilon;
    private double epsilonDecay;
    
    private int episode;
    
    private int lastAction;
    private Map<String, List<Double>> qTable;
    
    public ControllerSimulation() {
        this.simulationMap = new SimulationMap();
        this.agentWalker   = new AgentWalker();
        this.observers     = new ArrayList<>();
        this.qTable        = new HashMap<>();
        this.episode = 0;
    }
    
    public static ControllerSimulation getInstance() {
        if (instance == null) {
            instance = new ControllerSimulation();
        }
        return instance;
    }
    
    public void addObserver(InterfaceViewObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(InterfaceViewObserver observer) {
        this.observers.remove(observer);
    }

    public SimulationMap getSimulationMap() {
        return simulationMap;
    }

    public void setSimulationMap(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public AgentWalker getAgentWalker() {
        return agentWalker;
    }

    public void setAgentWalker(AgentWalker agentWalker) {
        this.agentWalker = agentWalker;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getEpsilonDecay() {
        return epsilonDecay;
    }

    public void setEpsilonDecay(double epsilonDecay) {
        this.epsilonDecay = epsilonDecay;
    }
            
    public void loadSimulation(File arquivo) throws IOException {
       BufferedReader in = new BufferedReader(new FileReader(arquivo));
        this.arquivo = arquivo;
        
        int linhas  = Integer.parseInt(in.readLine());
        int colunas = Integer.parseInt(in.readLine());
        
        PathCell[][] map = new PathCell[linhas][colunas];
        PathCell initial = null;
        
        for (int x = 0; x < linhas; x++) {
            String[] listTypes = in.readLine().split("\t");
            for (int y = 0; y < colunas; y++) {
                int type = Integer.parseInt(listTypes[y]);
                map[x][y] = new PathCell(x, y, type);
                if(type == 1) {
                    map[x][y].setAgentWalker(agentWalker);
                    map[x][y].getAgentWalker().setPathCell(map[x][y]);
                    
                    initial = map[x][y];
                }
            }
        }
                
        this.simulationMap.setRows(linhas);
        this.simulationMap.setColumns(colunas);
        this.simulationMap.setMap(map);
        this.simulationMap.setInitial(initial);
        
        this.configNeighborhood();
    }
    
    public void configNeighborhood() {
        PathCell[][] map = this.getSimulationMap().getMap();
        
        for (int x = 0; x < getSimulationMap().getRows(); x++) {
            for (int y = 0; y < getSimulationMap().getColumns(); y++) {
                this.addNeighborhood(map[x][y]);
            }
        }
    }
    
    private void addNeighborhood(PathCell pathCell) {
        int linha  = pathCell.getX();
        int coluna = pathCell.getY();
        
        PathCell[][] map = getSimulationMap().getMap();

        if (verifyIndex(linha, coluna - 1)) {
            pathCell.setPathLeft(map[linha][coluna - 1]);
        }

        if (verifyIndex(linha, coluna + 1)) {
            pathCell.setPathRight(map[linha][coluna + 1]);
        }

        if (verifyIndex(linha + 1, coluna)) {
            pathCell.setPathDown(map[linha + 1][coluna]);
        }

        if (verifyIndex(linha - 1, coluna)) {
            pathCell.setPathUp(map[linha - 1][coluna]);
        }        
    }

    private boolean verifyIndex(int x, int y) {
        return (x >= 0 && x < getSimulationMap().getMap().length) && (y >= 0 && y < getSimulationMap().getMap()[0].length);
    }
    
    public void play() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                while(isStart()) {
                    if(isEndEpisode()) {
                        resetEpisode();
                    } else {
                        PathCell prox = chooseAnAction();
                        executeAction(prox);
                        learn();                        
                    }
                    publish(); 
                }
                return null;
            }

            @Override
            protected void process(List<Void> chunks) {
                notifyTableModelChanged();
            }
        };

        worker.execute();         
    }
    
    public void newEpisode() {
        this.episode++;
    }
    
    public PathCell chooseAnAction() {
        Random random = new Random();
        double sorted = random.nextDouble();
        
        int direction;
        if(sorted <= epsilon) {
            direction = random.nextInt(4); 
        } else {
            String state = agentWalker.getPathCell().getX() + "," + agentWalker.getPathCell().getY();
            List<Double> actionsValues = qTable.get(state);
            if(actionsValues == null || actionsValues.isEmpty()) {
                direction = random.nextInt(4); 
            } else {
                direction = actionsValues.indexOf(Collections.max(actionsValues));
            }
        }
        
        epsilon = epsilon * epsilonDecay;
        System.out.println("Epsilon: " + epsilon);
        
        switch (direction) {
            case 0:
                lastAction = Actions.LEFT.getValue();
                return this.getAgentWalker().goLeft();
            case 1:
                lastAction = Actions.UP.getValue();
                return this.getAgentWalker().goUp();
            case 2:
                lastAction = Actions.RIGHT.getValue();
                return this.getAgentWalker().goRight();
            default:
                lastAction = Actions.DOWN.getValue();
                return this.getAgentWalker().goDown();
        }
    }
    
    public void executeAction(PathCell prox) {
        if(prox != null) {
            PathCell atual = this.getAgentWalker().getPathCell();
            this.getSimulationMap().getMap()[prox.getX()][prox.getY()].setAgentWalker(agentWalker);
            this.getSimulationMap().getMap()[atual.getX()][atual.getY()].setAgentWalker(null);
            agentWalker.setPathCell(prox);
            notifyTableModelChanged();   

            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void learn() {
        String newState = agentWalker.getPathCell().getX() + "," + agentWalker.getPathCell().getY();
        
        if(qTable.get(newState) == null || qTable.get(newState).isEmpty()) {
            List<Double> listZeros = new ArrayList<>(Collections.nCopies(4, 0.0));
            qTable.put(newState, listZeros);
        } 
        
        List<Double> actionsValues = qTable.get(newState);
       
        double actualQValue = actionsValues.get(lastAction);
        double newStateBestAction = Collections.max(actionsValues);
        double newQValue = actualQValue + learningRate*(getReward() + (discountFactor * newStateBestAction) - actualQValue); 
        
        actionsValues.set(lastAction, newQValue);
                
        qTable.put(newState, actionsValues);
        
        System.out.println("Q TABLE");
        System.out.println(qTable.toString());
    }
    
    public int getReward() {
        switch(this.getAgentWalker().getPathCell().getType()) {
            case 0: 
                return -100;
            case 1: case 2: case 3:
                return -1;
        }
        
        return 0;
    }
    
    public boolean isEndEpisode() {
        return getAgentWalker().getPathCell().getType() == 2 || getAgentWalker().getPathCell().getType() == 0;
    }
    
    public void resetEpisode() {
        executeAction(this.getSimulationMap().getInitial());
    }
    
     public void notifyTableModel(TableModelMap tableModelMap) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.updateTableModel(tableModelMap);
        }
    }

    public synchronized void notifyTableModelChanged() {
        for (InterfaceViewObserver observer : this.observers) {
            observer.updateTableChanged();
        }
    }

    public void notifyButtonChanged(boolean iniciar) {
        for (InterfaceViewObserver observer : this.observers) {
            observer.updateShowException(iniciar);
        }
    }
}
