package maze;

import prototypal.PrototypeMaze;

public class StartCell extends ReachableCell {

    private StartCell(StartCell sc) {
        super(sc);
    }

    void goToPreviousLevel() {

    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new StartCell(this);
    }
}
