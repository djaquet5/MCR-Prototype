package maze;

import display.GameDisplayer;
import prototypal.PrototypeMaze;

import java.awt.*;

public abstract class Cell implements PrototypeMaze {

    private Dungeon dungeon;
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

    public void initialize(Dungeon dungeon, int posX, int posY) {
        this.dungeon = dungeon;
        this.posX = posX;
        this.posY = posY;
    }

    public abstract void draw(Graphics2D g, GameDisplayer observer);

    public abstract Cell clone();
}