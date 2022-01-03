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

    public ControllerSimulation() {
        this.simulationMap = new SimulationMap();
        this.agentWalker   = new AgentWalker();
        this.observers     = new ArrayList<>();
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
            }
        }
        
        this.simulationMap.setRows(linhas);
        this.simulationMap.setColumns(colunas);
        this.simulationMap.setMap(map);
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
