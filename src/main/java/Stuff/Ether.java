package Stuff;

import Maze.ReachableCell;

public class Ether extends Item {

    public Ether() {
        super("Ether", "PATH");
    }

    @Override
    public Item clone(){
        return new Ether();
    }
}
