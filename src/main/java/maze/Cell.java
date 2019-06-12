package maze;

import display.GameDisplayer;
import prototypal.PrototypeMaze;

import javax.swing.*;
import java.awt.*;


public abstract class Cell implements PrototypeMaze {

    private int posX;
    private int posY;
    protected boolean isDiscovered;

    Cell(Cell c) {
        this.posX = c.posX;
        this.posY = c.posY;
        this.isDiscovered = true;
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

    public String getFontPath(){
        return "src/textures/dirt.png";
    }

    public boolean getIsDiscovered(){
        return isDiscovered;
    }

    @Override
    public abstract PrototypeMaze cloneMaze();


    public void draw(Graphics2D g2d) {
        GameDisplayer gameDisplayer = GameDisplayer.getInstance();
        Image sol  = new ImageIcon(getFontPath()).getImage();
        g2d.drawImage(sol, gameDisplayer.getCellOffset() + getPosX() * gameDisplayer.getCellSize(),
                gameDisplayer.getCellOffset() + getPosY() * gameDisplayer.getCellSize(), gameDisplayer.getImageSize(),
                gameDisplayer.getImageSize(), gameDisplayer);
    }

    protected void drawCross(Graphics2D g2d) {
        GameDisplayer gameDisplayer = GameDisplayer.getInstance();

        g2d.drawLine(getPosX() * gameDisplayer.getCellSize() + gameDisplayer.getCellOffset(),
                getPosY() * gameDisplayer.getCellSize() + gameDisplayer.getCellOffset(),
                (getPosX() + 1) * gameDisplayer.getCellSize() - gameDisplayer.getCellOffset(),
                (getPosY() + 1) * gameDisplayer.getCellSize() - gameDisplayer.getCellOffset());

        g2d.drawLine(getPosX() * gameDisplayer.getCellSize() + gameDisplayer.getCellOffset() ,
                (getPosY() + 1) * gameDisplayer.getCellSize() - gameDisplayer.getCellOffset(),
                (getPosX() + 1) * gameDisplayer.getCellSize() - gameDisplayer.getCellOffset(),
                getPosY() * gameDisplayer.getCellSize() + gameDisplayer.getCellOffset());
    }
}