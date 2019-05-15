package Maze;

public class StartCell extends ReachableCell {

    private StartCell(StartCell sc) {
        super(sc);
    }

    void goToPreviousLevel() {

    }

    @Override
    public Cell clone() {
        return new StartCell(this);
    }
}
