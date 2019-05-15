package maze;

import java.awt.*;

public class EmptyCell extends Cell {

    private EmptyCell(EmptyCell rc) {
        super(rc);
    }

    public EmptyCell(){
        super(Color.BLACK);
    }

    @Override
    public Cell clone() {
        return new EmptyCell(this);
    }
}