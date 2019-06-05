package prototypal;

import maze.*;
import stuff.*;

public class GameFactory {
    //Cell
    private static EmptyCell prototypeEmptyCell;
    private static ReachableCell prototypeReachableCell;


    //Item
    private static Potion prototypePotion;
    private static Ether prototypeEther;


    public GameFactory() {
        prototypeEmptyCell = new EmptyCell();
        prototypeReachableCell = new ReachableCell();

        prototypePotion = new Potion();
        prototypeEther = new Ether();
    }

    public static Cell MakeEmptyCell(Dungeon dungeon, int x, int y){
        Cell ec = (EmptyCell) prototypeEmptyCell.cloneMaze();
        ec.initialize(dungeon, x, y);
        return ec;
    }

    public static Cell MakeReachableCell(Dungeon dungeon, int x, int y){
        Cell ec = (ReachableCell) prototypeReachableCell.cloneMaze();
        ec.initialize(dungeon, x, y);
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
