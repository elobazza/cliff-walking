package view.tablemodel;

import java.awt.Color;
import java.awt.Component;
import java.util.Objects;
import javax.swing.ImageIcon;
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
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/cliff.png")));
                    super.setIcon(imagem);
                    break;
//                    Color cor = new Color(0, 0, 250); // BLUE
//                    super.setBackground(cor);
//                    break;
                }
                case 1: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/initial.png")));
                    
                    super.setIcon(imagem);
                    break;
//                    Color cor = new Color(250, 0, 0); // RED
//                    super.setBackground(cor);
//                    break;
                }
                case 2: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/final.png")));
                    super.setIcon(imagem);
                    break;
//                    Color cor = new Color(0, 128, 0); // GREEN
//                    super.setBackground(cor);
//                    break;
                }
                case 3: {
                    ImageIcon imagem = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/normal.png")));
                    super.setIcon(imagem);
                    break;
//                    Color cor = new Color(128, 128, 128); // GRAY
//                    super.setBackground(cor);
//                    break;
                }
//                default : {
//                    Color cor = new Color(65, 105, 225);
//                    super.setBackground(cor);
//                    break;
//                }
            }

            if(!pathCell.isFree()) {
//                Color cor = new Color(128, 128, 128); // GRAY
//                super.setBackground(cor);
                super.setIcon(pathCell.getAgentWalker().getIcon());  
            }
            
        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        super.repaint();
        return this;
    }
    
}
