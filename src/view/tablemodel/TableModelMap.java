package view.tablemodel;

import javax.swing.table.AbstractTableModel;
import observer.InterfaceControllerObserved;

/**
 * Table Model Map Class
 * @author Eloisa Bazzanella
 */
public class TableModelMap extends AbstractTableModel {
    
    private InterfaceControllerObserved controller;

    public TableModelMap(InterfaceControllerObserved controller) {
        this.controller = controller;
    }
    
    @Override
    public int getRowCount() {
        return this.controller.getSimulationMap().getRows();
    }

    @Override
    public int getColumnCount() {
        return this.controller.getSimulationMap().getColumns();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.controller.getSimulationMap().getMap()[rowIndex][columnIndex];
    }
    
}
