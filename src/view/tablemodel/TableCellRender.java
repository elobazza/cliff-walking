package view.tablemodel;

import java.awt.Color;
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
        if(object != null) {
            PathCell pathCell = (PathCell) object;

            switch(pathCell.getType()) {

                case 0: {
                    Color cor = new Color(0, 0, 250); // BLUE
                    super.setBackground(cor);
                    break;
                }
                case 1: {
                    Color cor = new Color(250, 0, 0); // RED
                    super.setBackground(cor);
                    break;
                }
                case 2: {
                    Color cor = new Color(0, 128, 0); // GREEN
                    super.setBackground(cor);
                    break;
                }
                case 3: {
                    Color cor = new Color(128, 128, 128); // GRAY
                    super.setBackground(cor);
                    break;
                }
//                default : {
//                    Color cor = new Color(65, 105, 225);
//                    super.setBackground(cor);
//                    break;
//                }
            }

//            if(!pathCell.isFree()) {
//
//            }
            
        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        return this;
    }
    
}
