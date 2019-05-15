package prototypal;

import maze.ReachableCell;

public interface Prototype extends Cloneable {
    public void initialize(ReachableCell cell);
}
