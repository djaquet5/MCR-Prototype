package Maze;

public class ReachableCell extends Cell {

    public ReachableCell(ReachableCell rc) {
        super(rc);
    }

    @Override
    public Cell clone() {
        return new ReachableCell(this);
    }
}