package maze;

import com.sun.org.apache.xpath.internal.operations.Bool;
import prototypal.PrototypeMaze;

import java.awt.*;

public abstract class Cell implements PrototypeMaze {

    private Donjon donjon;
    private int posX;
    private int posY;
    private Color color;
    private Boolean isDiscovered;

    Cell(Cell c) {
        this.posX = c.posX;
        this.posY = c.posY;
        this.color = c.color;
        this.isDiscovered = false;
    }

    public Cell(Color color){
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Color getColor() {
        return color;
    }

    public void initialize(Donjon donjon, int posX, int posY) {
        this.donjon = donjon;
        this.posX = posX;
        this.posY = posY;
    }

    public void discover(){
        this.isDiscovered = true;
    }

    public Boolean isReachable(){
        return false;
    }

    @Override
    public abstract PrototypeMaze cloneMaze();
}