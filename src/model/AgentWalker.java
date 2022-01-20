package model;

import java.util.Objects;
import javax.swing.ImageIcon;


/**
 * Agent Walker Model
 * @author Eloísa Bazzanella
 */
public class AgentWalker {
    
    private PathCell pathCell;
    private ImageIcon icon;

    public AgentWalker() {
        this.icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/img/walker.png")));;
    }

    public PathCell getPathCell() {
        return pathCell;
    }

    public void setPathCell(PathCell pathCell) {
        this.pathCell = pathCell;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
    public void goUp() {
        
    }
    
    public void goDown() {
        
    }
    
    public void goRight() {
        
    }
    
    public void goLeft() {
        
    }
    
}
