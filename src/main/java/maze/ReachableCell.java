package maze;

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
    public PrototypeMaze cloneMaze() {
        return new ReachableCell(this);
    }
}