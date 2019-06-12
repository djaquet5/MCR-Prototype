package maze;

import prototypal.PrototypeMaze;

import java.awt.*;

public class EndCell extends ReachableCell {

    public EndCell() {
        super();
    }

    private EndCell(EndCell ec) {
        super(ec);
    }

    void goToNextLevel() {

    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new EndCell(this);
    }


    public void draw(Graphics2D g2d) {
        super.draw(g2d);

        g2d.setColor(Color.RED);

        drawCross(g2d);
    }
}
