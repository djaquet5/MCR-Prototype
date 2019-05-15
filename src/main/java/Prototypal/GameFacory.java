package Prototypal;

import Stuff.Item;
import Stuff.Potion;

public class GameFacory{
    private Potion prototypePotion;


    public GameFacory() {
        prototypePotion = new Potion();
    }

    public Item MakePotion(Cell cell) {
        Potion p = (Potion) prototypePotion.clone();
        p.initialize(cell);
        return p;
    }

}
