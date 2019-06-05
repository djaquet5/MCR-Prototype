package maze;

import display.GameDisplayer;

import java.awt.*;

public class EmptyCell extends Cell {

    private EmptyCell(EmptyCell rc) {
        super(rc);
    }

    public EmptyCell(){
        super(Color.BLACK);
    }

    @Override
    public void draw(Graphics2D g, GameDisplayer observer) {

    }

    @Override
    public Cell clone() {
        return new EmptyCell(this);
    }
}