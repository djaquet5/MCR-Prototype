package maze;

import prototypal.PrototypeMaze;

public class ReachableCell extends Cell {

    public ReachableCell(ReachableCell rc) {
        super(rc);
    }

    public ReachableCell(){
        super();
    }

    @Override
    public boolean isReachable() {
        return true;
    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new ReachableCell(this);
    }
}