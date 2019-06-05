package entity;

import maze.Cell;

public class Monster extends Character {

    private Cell cell;

    /**
     * Initialize starting position
     * @param cell
     */
    private Monster(Cell cell) {
        this.cell = cell;
    }

    public Monster(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
    }

}
