package prototypal;

import maze.Dungeon;

public interface PrototypeMaze extends Cloneable {
    public void initialize(Dungeon dungeon, int posX, int posY);
}
