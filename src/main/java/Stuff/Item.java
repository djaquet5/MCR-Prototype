package Stuff;

import Maze.ReachableCell;
import Prototypal.Prototype;

public abstract class Item implements Prototype {
    String nom;
    String image;

    public Item(String nom, String image){
        this.nom = nom;
        this.image = image;
    }

    public void initialize(ReachableCell cell) {
        cell.addItem(this);
    }
}
