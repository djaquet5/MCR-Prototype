package maze;

import prototypal.PrototypeMaze;

public class EmptyCell extends Cell {

    private EmptyCell(EmptyCell rc) {
        super(rc);
    }

    public EmptyCell(){
        super();
    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new EmptyCell(this);
    }
}