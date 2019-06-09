package maze;

import java.util.LinkedList;
import java.util.Random;

import static prototypal.GameFactory.*;

/**
 * Square dungeon made up of Cells.
 */
public class Dungeon {
    private Cell[][] cells;

    public Dungeon(int sizeX, int sizeY) {
        cells = new Cell[sizeX][sizeY];

        for(int i = 0; i < sizeX; ++i){
            for(int j = 0; j < sizeY; ++j){
                cells[i][j] = MakeReachableCell(i, j);
            }
        }
    }

    public Dungeon(int[][] cellConfig) {
        int sizeX = cellConfig.length;
        int sizeY = cellConfig[0].length;

        cells = new Cell[sizeX][sizeY];

        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                if(cellConfig[i][j] == 0) {
                    this.cells[i][j] = MakeEmptyCell(i, j);
                } else {
                    this.cells[i][j] = MakeReachableCell(i, j);
                }
            }
        }
    }

    private boolean isReachable(int x, int y){
        return cells[x][y].isReachable();
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

    public static void main(String[] args) {
        int[][] cells = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 0}
        };
        Dungeon dungeon = new Dungeon(cells);

        for(int i = 0; i < dungeon.getDimension(); i++) {
            for(int j = 0; j < dungeon.getDimension(); j++) {
                Cell currentCell = dungeon.getCells()[i][j];
                if(currentCell != null)
                System.out.println("Cell[" + currentCell.getPosX()+ "][" + currentCell.getPosY() + "]");
            }
        }
    }
}
