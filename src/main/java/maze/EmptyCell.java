package maze;

public class EmptyCell extends Cell {

    private EmptyCell(EmptyCell rc) {
        super(rc);
    }

    @Override
    public Cell clone() {
        return new EmptyCell(this);
    }
}