package maze;

import display.GameDisplayer;
import prototypal.PrototypeMaze;

import java.awt.*;

public class ReachableCell extends Cell {
    public ReachableCell(ReachableCell rc) {
        super(rc);
    }

    public ReachableCell(){
        super(Color.WHITE);
    }

    @Override
    public void draw(Graphics2D g, GameDisplayer observer) {
        g.drawImage(GameDisplayer.STONE, 5 + getPosX() * 100, 5 + getPosY() * 100, 90, 90, observer);
    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new ReachableCell(this);
    }
}