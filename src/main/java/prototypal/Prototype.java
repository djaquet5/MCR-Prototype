package prototypal;

import maze.ReachableCell;

public interface Prototype {
    void initialize(ReachableCell cell);
    Prototype clonePrototype();
}
