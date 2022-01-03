package observer;

import view.tablemodel.TableModelMap;

/**
 * Interface View Observer
 * @author Eloisa Bazzanella
 */
public interface InterfaceViewObserver {
    
    public void updateTableChanged();
    
    public void updateTableModel(TableModelMap tableModelMap);
    
    public void updateShowException(Boolean exception);
}
