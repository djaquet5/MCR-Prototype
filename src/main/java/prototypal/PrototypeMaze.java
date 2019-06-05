package prototypal;

import maze.Dungeon;

public interface PrototypeMaze {
    void initialize(Dungeon donjon, int posX, int posY);
    PrototypeMaze cloneMaze();
}
