package Maze;

import Prototypal.PrototypeMaze;

import java.awt.*;

public abstract class Cell implements PrototypeMaze {

    private Donjon donjon;
    private int posX;
    private int posY;
    private Color color;

    Cell(Cell c) {
        this.posX = c.posX;
        this.posY = c.posY;
        this.color = c.color;
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

    public abstract Cell clone();
}