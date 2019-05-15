package Stuff;

import Maze.Cell;
import Maze.ReachableCell;

public class Potion extends Item {

    public Potion(){
        super("Potion", "PATH");
    }

    public void initialize(ReachableCell cell) {

    }

    @Override
    public Item clone(){
        return new Potion();
    }
}
