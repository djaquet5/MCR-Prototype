package Maze;

public class EndCell extends ReachableCell {

    private EndCell(EndCell ec) {
        super(ec);
    }

    void goToNextLevel() {

    }

    @Override
    public Cell clone() {
        return new EndCell(this);
    }
}
