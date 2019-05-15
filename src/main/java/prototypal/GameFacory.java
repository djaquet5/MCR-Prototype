package prototypal;

import maze.Cell;
import maze.ReachableCell;
import stuff.Item;
import stuff.Potion;

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
