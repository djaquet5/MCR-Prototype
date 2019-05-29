package maze;


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
}
