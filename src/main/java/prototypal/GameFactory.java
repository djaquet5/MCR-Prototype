package prototypal;

import maze.*;
import stuff.*;

public class GameFactory {
    //Cell
    private final static EmptyCell prototypeEmptyCell = new EmptyCell();;
    private final static ReachableCell prototypeReachableCell = new ReachableCell();


    //Item
    private final static Potion prototypePotion = new Potion();
    private final static Ether prototypeEther = new Ether();


    public GameFactory() {

    }

    public static Cell MakeEmptyCell(int x, int y){
        Cell emptyCell = (EmptyCell) prototypeEmptyCell.cloneMaze();
        emptyCell.initialize(x, y);
        return emptyCell;
    }

    public static Cell MakeReachableCell(int x, int y){
        Cell reachableCell = (ReachableCell) prototypeReachableCell.cloneMaze();
        reachableCell.initialize(x, y);
        return reachableCell;
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
