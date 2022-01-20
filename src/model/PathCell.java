package model;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Path Cell Model
 * @author Eloisa Bazzanella
 */
public class PathCell {
    
    private int x;
    private int y;
    private int type;
    
    private Color color;
    private ImageIcon icon;
   
    private AgentWalker agentWalker;
    
    private PathCell pathLeft;
    private PathCell pathRight;
    private PathCell pathUp;
    private PathCell pathDown;

    public PathCell() {}

    public PathCell(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;   
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public AgentWalker getAgentWalker() {
        return agentWalker;
    }

    public void setAgentWalker(AgentWalker agentWalker) {
        this.agentWalker = agentWalker;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
    public boolean isFree() {
        return this.agentWalker == null;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PathCell getPathLeft() {
        return pathLeft;
    }

    public void setPathLeft(PathCell pathLeft) {
        this.pathLeft = pathLeft;
    }

    public PathCell getPathRight() {
        return pathRight;
    }

    public void setPathRight(PathCell pathRight) {
        this.pathRight = pathRight;
    }

    public PathCell getPathUp() {
        return pathUp;
    }

    public void setPathUp(PathCell pathUp) {
        this.pathUp = pathUp;
    }

    public PathCell getPathDown() {
        return pathDown;
    }

    public void setPathDown(PathCell pathDown) {
        this.pathDown = pathDown;
    }
    
}
