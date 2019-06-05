package maze;

import prototypal.Prototype;
import prototypal.PrototypeMaze;

public class EndCell extends ReachableCell {

    private EndCell(EndCell ec) {
        super(ec);
    }

    void goToNextLevel() {

    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new EndCell(this);
    }
}
