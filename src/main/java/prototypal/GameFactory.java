package prototypal;

import entity.monster.*;
import maze.*;
import stuff.*;

public class GameFactory {
    //Cell
    private final static EmptyCell prototypeEmptyCell = new EmptyCell();
    private final static ReachableCell prototypeReachableCell = new ReachableCell();


    //Item
    private final static Potion prototypePotion = new Potion();
    private final static Ether prototypeEther = new Ether();

    //Monster
    private  final static Slime prototypeSlime = new Slime();
    private final static Squid prototypeSquid = new Squid();
    private final static Octopus prototypeOctopus = new Octopus();
    private final static Kraken prototypeKraken = new Kraken();
    private final static Summoner prototypeSummoner = new Summoner();


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

    public static Monster MakeSlime(ReachableCell cell){
        Slime s = (Slime)prototypeSlime.clonePrototype();
        s.initialize(cell);
        return s;
    }

    public static Monster MakeSquid(ReachableCell cell){
        Squid s = (Squid)prototypeSquid.clonePrototype();
        s.initialize(cell);
        return s;
    }

    public static Monster MakeOctopus(ReachableCell cell){
        Octopus o = (Octopus)prototypeOctopus.clonePrototype();
        o.initialize(cell);
        return o;
    }

    public static Monster MakeKraken(ReachableCell cell){
        Kraken k = (Kraken)prototypeKraken.clonePrototype();
        k.initialize(cell);
        return k;
    }

    public static Monster MakeSummoner(ReachableCell cell){
        Summoner s = (Summoner)prototypeSummoner.clonePrototype();
        s.initialize(cell);
        return s;
    }

}
