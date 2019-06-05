package maze;

import prototypal.GameFactory;

public class Dungeon {
    private Cell[][] cellules;

    public Dungeon(int x, int y){
        cellules = new Cell[x][y];
        for(int i = 0; i < x; ++i){
            for(int j = 0; j < y; ++j){

                cellules[x][y] = GameFactory.MakeEmptyCell(this, x, y);
            }
        }
    }
}
