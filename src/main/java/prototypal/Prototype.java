package prototypal;

import Maze.ReachableCell;

public interface Prototype extends Cloneable {
    public void initialize(ReachableCell cell);
}
