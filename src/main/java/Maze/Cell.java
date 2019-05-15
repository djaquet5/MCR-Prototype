package Maze;

import java.awt.*;

public abstract class Cell {

    private int posX;
    private int posY;
    private Color color;

    Cell(Cell c) {
        this.posX = c.posX;
        this.posY = c.posY;
        this.color = c.color;
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

    public abstract Cell clone();
}