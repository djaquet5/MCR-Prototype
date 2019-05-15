package Prototypal;

import Maze.Cell;
import Maze.ReachableCell;
import Stuff.Item;
import Stuff.Potion;

public class GameFacory{
    private Potion prototypePotion;


    public GameFacory() {
        prototypePotion = new Potion();
    }

    public Item MakePotion(ReachableCell cell) {
        Potion p = (Potion) prototypePotion.clone();
        p.initialize(cell);
        return p;
    }

}
