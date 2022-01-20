package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    public ControllerSimulation() {
        this.simulationMap = new SimulationMap();
        this.agentWalker   = new AgentWalker();
        this.observers     = new ArrayList<>();
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
        
        for (int x = 0; x < linhas; x++) {
            String[] listTypes = in.readLine().split("\t");
            for (int y = 0; y < colunas; y++) {
                int type = Integer.parseInt(listTypes[y]);
                map[x][y] = new PathCell(x, y, type);
                if(type == 1) {
                    map[x][y].setAgentWalker(agentWalker);
                    map[x][y].getAgentWalker().setPathCell(map[x][y]);
                }
            }
        }
                
        this.simulationMap.setRows(linhas);
        this.simulationMap.setColumns(colunas);
        this.simulationMap.setMap(map);
        
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
        while(isStart()) {
            
            this.newEpisode();
            
            this.chooseAnAction();
            
            this.executeAction();
            
            notifyTableModelChanged();
            
            this.updateQTable();
            
            if(this.isEndEpisode()) {
                this.resetEpisode();
                notifyTableModelChanged();
            }
            
        }
        
//        PathCell atual = this.getAgentWalker().getPathCell();
//        PathCell prox  = this.getAgentWalker().goUp();
//        
//        this.getSimulationMap().getMap()[prox.getX()][prox.getY()].setAgentWalker(agentWalker);
//        this.getSimulationMap().getMap()[atual.getX()][atual.getY()].setAgentWalker(null);
                
    }
    
    public void newEpisode() {
        this.episode++;
    }
    
    public void chooseAnAction() {
        
    }
    
    public void executeAction() {
        
    }
    
    public void updateQTable() {
        
    }
    
    public boolean isEndEpisode() {
        return getAgentWalker().getPathCell().getType() == 2 && getAgentWalker().getPathCell().getType() == 0;
    }
    
    public void resetEpisode() {
        
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
