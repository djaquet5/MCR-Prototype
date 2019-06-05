package maze;


import java.util.LinkedList;
import java.util.Random;

import static prototypal.GameFacory.*;

public class Donjon {
    private Cell[][] cellules;

    public Donjon(int x, int y){
        cellules = new Cell[x][y];
        for(int i = 0; i < x; ++i){
            for(int j = 0; j < y; ++j){
                cellules[x][y] = MakeEmptyCell(this, x, y);
            }
        }
    }

    public boolean isReachable(int x, int y){
        return cellules[x][y].isReachable();
    }

    public Cell getCell(int x, int y){
        if(x < 0) x = 0;
        if(y < 0) y = 0;
        return cellules[x][y];
    }

    public ReachableCell getRandomAdjacentReachableCell(ReachableCell rc){
        LinkedList<ReachableCell> cells = new LinkedList<>();
        if(isReachable(rc.getPosX(), rc.getPosY() - 1))
            cells.add((ReachableCell) cellules[rc.getPosX()][rc.getPosY() - 1]);
        if(isReachable(rc.getPosX(), rc.getPosY() + 1))
            cells.add((ReachableCell) cellules[rc.getPosX()][rc.getPosY() + 1]);
        if(isReachable(rc.getPosX() - 1, rc.getPosY()))
            cells.add((ReachableCell) cellules[rc.getPosX() - 1][rc.getPosY()]);
        if(isReachable(rc.getPosX() + 1, rc.getPosY()))
            cells.add((ReachableCell) cellules[rc.getPosX() + 1][rc.getPosY()]);
        Random rand = new Random();
        return cells.get(rand.nextInt(cells.size()));
    }
}
