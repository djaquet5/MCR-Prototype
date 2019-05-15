package Prototypal;

import Maze.ReachableCell;
import Stuff.*;

public class GameFacory{
    private Potion prototypePotion;
    private Ether prototypeEther;


    public GameFacory() {
        prototypePotion = new Potion();
        prototypeEther = new Ether();
    }

    public Item MakePotion(ReachableCell cell) {
        Potion p = (Potion) prototypePotion.clone();
        p.initialize(cell);
        return p;
    }

    public Item MakeEther(ReachableCell cell){
        Ether e = (Ether) prototypeEther.clone();
        e.initialize(cell);
        return e;
    }

}
