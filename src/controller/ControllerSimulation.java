package controller;

import java.io.File;
import model.AgentWalker;
import model.SimulationMap;

/**
 * Simulation Controller Class
 * @author Eloisa Bazzanella
 */
public class ControllerSimulation {
    
    private SimulationMap simulationMap;
    private AgentWalker   agentWalker;
    private boolean       start = true;
    
    private File arquivo;
    
    private static ControllerSimulation instance = null;

    public ControllerSimulation() {}
    
    public static ControllerSimulation getInstance() {
        if (instance == null) {
            instance = new ControllerSimulation();
        }
        return instance;
    }
}
