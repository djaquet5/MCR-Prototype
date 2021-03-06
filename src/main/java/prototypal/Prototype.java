package prototypal;

import maze.Cell;

public interface Prototype {
    void initialize(Cell cell);
    Prototype clonePrototype();
    String getDisplayImagePath();
    Cell getPosition();
}
