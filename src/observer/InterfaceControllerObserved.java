package observer;

import model.SimulationMap;

/**
 * Interface Controller Observed
 * @author Eloisa Bazzanella
 */
public interface InterfaceControllerObserved {
    
    public SimulationMap getSimulationMap();
    
    public void addObserver(InterfaceViewObserver observer);
    
    public void removeObserver(InterfaceViewObserver observer);
}
