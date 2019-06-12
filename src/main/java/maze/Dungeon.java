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

    public boolean isMonsterReachable(int x, int y) {
        return isReachable(x, y) && cells[x][y] != endCell;
    }

    public ReachableCell getRandomAdjacentReachableCell(Cell rc){
        LinkedList<ReachableCell> reachableCells = new LinkedList<>();

        if(isMonsterReachable(rc.getPosX(), rc.getPosY() - 1))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX()][rc.getPosY() - 1]);

        if(isMonsterReachable(rc.getPosX(), rc.getPosY() + 1))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX()][rc.getPosY() + 1]);

        if(isMonsterReachable(rc.getPosX() - 1, rc.getPosY()))
            reachableCells.add((ReachableCell) this.cells[rc.getPosX() - 1][rc.getPosY()]);

        if(isMonsterReachable(rc.getPosX() + 1, rc.getPosY()))
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
