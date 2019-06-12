package maze;

import java.util.LinkedList;
import java.util.Random;

import static prototypal.GamePrototypeManager.*;

/**
 * Square dungeon made up of Cells.
 */
public class Dungeon {
    private Cell[][] cells;
    private StartCell startCell;
    private EndCell endCell;
    private int x;
    private int y;

    public Dungeon(int[][] cellConfig) {
        x = cellConfig.length;
        y = cellConfig[0].length;

        cells = new Cell[x][y];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(cellConfig[i][j] == 0) {
                    this.cells[i][j] = MakeEmptyCell(i, j);
                }  else if(cellConfig[i][j] == 9) {
                    this.startCell = MakeStartCell(i, j);
                    this.cells[i][j] = this.startCell;
                } else if(cellConfig[i][j] == 10) {
                    this.endCell = MakeEndCell(i, j);
                    this.cells[i][j] = this.endCell;
                } else {
                    this.cells[i][j] = MakeReachableCell(i, j);
                    switch (cellConfig[i][j]) {
                        case 2:
                            MakeSlime((ReachableCell) this.cells[i][j]);
                            break;
                        case 3:
                            MakeSquid((ReachableCell) this.cells[i][j]);
                            break;
                        case 4:
                            MakeOctopus((ReachableCell) this.cells[i][j]);
                            break;
                        case 5:
                            MakeSummoner((ReachableCell) this.cells[i][j]);
                            break;
                        case 6:
                            MakeKraken((ReachableCell) this.cells[i][j]);
                            break;
                        case 7:
                            MakePotion((ReachableCell) this.cells[i][j]);
                            break;
                        case 8:
                            MakeEther((ReachableCell) this.cells[i][j]);
                            break;
                    }
                }
            }
        }
    }

    public boolean isReachable(int x, int y){
        try {
            return cells[x][y].isReachable();
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public ReachableCell getRandomAdjacentReachableCell(Cell rc){
        LinkedList<ReachableCell> reachableCells = new LinkedList<>();

        if(isReachable(rc.getPosX(), rc.getPosY() - 1))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX()][rc.getPosY() - 1]);

        if(isReachable(rc.getPosX(), rc.getPosY() + 1))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX()][rc.getPosY() + 1]);

        if(isReachable(rc.getPosX() - 1, rc.getPosY()))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX() - 1][rc.getPosY()]);

        if(isReachable(rc.getPosX() + 1, rc.getPosY()))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX() + 1][rc.getPosY()]);

        Random rand = new Random();

        return reachableCells.get(rand.nextInt(reachableCells.size()));
    }

    public int getDimension() {
        return cells.length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int posX, int posY) {
        return cells[posX][posY];
    }

    public static Dungeon generate10x10Dungeon() {
        int[][] cells = new int[][]{
                {9, 7, 7, 1, 0, 0, 0, 1, 7, 8},
                {1, 2, 1, 1, 0, 0, 1, 1, 7, 8},
                {7, 1, 8, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 2, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 8, 0, 8, 1, 1, 4, 0},
                {0, 1, 3, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 2, 0, 1, 1, 1},
                {0, 4, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 7, 1, 1, 0, 1, 1, 6},
                {0, 7, 1, 5, 8, 1, 0, 10, 6, 0}
        };

        return new Dungeon(cells);
    }

    public int getMaxX(){
        return x;
    }

    public int getMaxY(){
        return y;
    }

    public StartCell getStartCell() {
        return startCell;
    }

    public EndCell getEndCell() {
        return endCell;
    }
}
