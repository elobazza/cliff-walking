package view.tablemodel;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.PathCell;

/**
 * Table Cell Render Class
 * @author Eloisa Bazzanella
 */
public class TableCellRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object object, boolean isSelected, boolean hasFocus, int row, int column) {
        
        PathCell pathCell = (PathCell) object;
        
        switch(pathCell.getType()) {
        
            case 1: {
                
                break;
            }
            case 2: {
                
                break;
            }
            case 3: {
                
                break;
            }
            case 4: {
                
                break;
            }
        }
        
        if(!pathCell.isFree()) {
            
        }
        
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        
        return this;
    }
    
}
