package prototypal;

import maze.Donjon;

public interface PrototypeMaze {
    void initialize(Donjon donjon, int posX, int posY);
    PrototypeMaze cloneMaze();
}
