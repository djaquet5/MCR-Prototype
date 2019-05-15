package prototypal;

import maze.Donjon;

public interface PrototypeMaze extends Cloneable {
    public void initialize(Donjon donjon, int posX, int posY);
}
