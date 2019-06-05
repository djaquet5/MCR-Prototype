package prototypal;

import maze.*;
import stuff.*;

public class GameFactory {
    //Cell
    private static EmptyCell prototypeEmptyCell;


    //Item
    private static Potion prototypePotion;
    private static Ether prototypeEther;


    public GameFactory() {
        prototypeEmptyCell = new EmptyCell();

        prototypePotion = new Potion();
        prototypeEther = new Ether();
    }

    public static Cell MakeEmptyCell(Dungeon dungeon, int x, int y){
        Cell ec = (EmptyCell) prototypeEmptyCell.clone();
        ec.initialize(dungeon, x, y);
        return ec;
    }

    public static Item MakePotion(ReachableCell cell) {
        Potion p = (Potion) prototypePotion.clone();
        p.initialize(cell);
        return p;
    }

    public static Item MakeEther(ReachableCell cell){
        Ether e = (Ether) prototypeEther.clone();
        e.initialize(cell);
        return e;
    }

}
