package maze;

import prototypal.PrototypeMaze;

public abstract class Cell implements PrototypeMaze {

    private int posX;
    private int posY;
    private boolean isDiscovered;

    Cell(Cell c) {
        this.posX = c.posX;
        this.posY = c.posY;
        this.isDiscovered = false;
    }

    public Cell(){
        this.posX = 0;
        this.posY = 0;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void initialize(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void discover(){
        this.isDiscovered = true;
    }

    public boolean isReachable(){
        return false;
    }

    @Override
    public abstract PrototypeMaze cloneMaze();
}