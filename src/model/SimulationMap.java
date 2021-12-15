package model;

/**
 * Simulation Map Model
 * @author Eloisa Bazzanella
 */
public class SimulationMap {
    
    private int rows;
    private int columns;
    
    private PathCell[][] map;

    public SimulationMap() {}
    
    public SimulationMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public PathCell[][] getMap() {
        return map;
    }

    public void setMap(PathCell[][] map) {
        this.map = map;
    }
    
    public int getValueAt(int row, int column) {
        PathCell pathCell =  map[row][column];
        return pathCell.getType();
    }
}
