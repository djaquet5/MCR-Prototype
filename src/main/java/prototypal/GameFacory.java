package prototypal;

import maze.*;
import stuff.*;

public class GameFacory{
    //Cell
    private static EmptyCell prototypeEmptyCell;
    private static ReachableCell prototypeReachableCell;


    //Item
    private static Potion prototypePotion;
    private static Ether prototypeEther;


    public GameFacory() {
        prototypeEmptyCell = new EmptyCell();
        prototypeReachableCell = new ReachableCell();

        prototypePotion = new Potion();
        prototypeEther = new Ether();
    }

    public static Cell MakeEmptyCell(Donjon donjon, int x, int y){
        Cell ec = (EmptyCell) prototypeEmptyCell.cloneMaze();
        ec.initialize(donjon, x, y);
        return ec;
    }

    public static Cell MakeReachableCell(Donjon donjon, int x, int y){
        Cell ec = (ReachableCell) prototypeReachableCell.cloneMaze();
        ec.initialize(donjon, x, y);
        return ec;
    }

    public static Item MakePotion(ReachableCell cell) {
        Potion p = (Potion) prototypePotion.clonePrototype();
        p.initialize(cell);
        return p;
    }

    public static Item MakeEther(ReachableCell cell){
        Ether e = (Ether) prototypeEther.clonePrototype();
        e.initialize(cell);
        return e;
    }

}
