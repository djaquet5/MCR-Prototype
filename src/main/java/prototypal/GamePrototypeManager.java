package prototypal;

import entity.monster.*;
import maze.*;
import stuff.*;

public class GamePrototypeManager {
    //Cell
    private final static EmptyCell prototypeEmptyCell = new EmptyCell();
    private final static ReachableCell prototypeReachableCell = new ReachableCell();
    private final static StartCell prototypeStartCell = new StartCell();
    private final static EndCell prototypeEndCell = new EndCell();



    //Item
    private final static Potion prototypePotion = new Potion();
    private final static Ether prototypeEther = new Ether();

    //Monster
    private  final static Slime prototypeSlime = new Slime();
    private final static Squid prototypeSquid = new Squid();
    private final static Octopus prototypeOctopus = new Octopus();
    private final static Kraken prototypeKraken = new Kraken();
    private final static Summoner prototypeSummoner = new Summoner();


    public GamePrototypeManager() {

    }

    public static Cell MakeEmptyCell(int x, int y){
        Cell emptyCell = (EmptyCell) prototypeEmptyCell.cloneMaze();
        emptyCell.initialize(x, y);
        return emptyCell;
    }

    public static ReachableCell MakeReachableCell(int x, int y){
        ReachableCell reachableCell = (ReachableCell) prototypeReachableCell.cloneMaze();
        reachableCell.initialize(x, y);
        return reachableCell;
    }

    public static StartCell MakeStartCell(int x, int y){
        StartCell startCell = (StartCell) prototypeStartCell.cloneMaze();
        startCell.initialize(x, y);
        return startCell;
    }

    public static EndCell MakeEndCell(int x, int y){
        EndCell endCell = (EndCell) prototypeEndCell.cloneMaze();
        endCell.initialize(x, y);
        return endCell;
    }

    public static void MakePotion(ReachableCell cell) {
        Potion p = (Potion) prototypePotion.clonePrototype();
        p.initialize(cell);
    }

    public static void MakeEther(ReachableCell cell){
        Ether e = (Ether) prototypeEther.clonePrototype();
        e.initialize(cell);
    }

    public static Item getPotion(){
        return prototypePotion;
    }

    public static Item getEther(){
        return prototypeEther;
    }

    public static void MakeSlime(ReachableCell cell){
        Slime s = (Slime)prototypeSlime.clonePrototype();
        s.initialize(cell);
    }

    public static void MakeSquid(ReachableCell cell){
        Squid s = (Squid)prototypeSquid.clonePrototype();
        s.initialize(cell);
    }

    public static void MakeOctopus(ReachableCell cell){
        Octopus o = (Octopus)prototypeOctopus.clonePrototype();
        o.initialize(cell);
    }

    public static void MakeKraken(ReachableCell cell){
        Kraken k = (Kraken)prototypeKraken.clonePrototype();
        k.initialize(cell);
    }

    public static void MakeSummoner(ReachableCell cell){
        Summoner s = (Summoner)prototypeSummoner.clonePrototype();
        s.initialize(cell);
    }

}
