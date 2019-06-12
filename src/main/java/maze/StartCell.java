package maze;

import prototypal.PrototypeMaze;

import java.awt.*;

public class StartCell extends ReachableCell {

    public StartCell() {
        super();
    }

    private StartCell(StartCell sc) {
        super(sc);
    }

    void goToPreviousLevel() {

    }

    @Override
    public PrototypeMaze cloneMaze() {
        return new StartCell(this);
    }

    public void draw(Graphics2D g2d) {
        super.draw(g2d);

        g2d.setColor(Color.GREEN);

        drawCross(g2d);
    }
}
