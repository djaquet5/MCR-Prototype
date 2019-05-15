package stuff;

import Maze.ReachableCell;
import Prototypal.Prototype;
import Person.Character;

public abstract class Item implements Prototype {
    private String nom;
    private String image;

    public Item(String nom, String image){
        this.nom = nom;
        this.image = image;
    }

    public abstract void heal(Character character);

    public void initialize(ReachableCell cell) {
        cell.addItem(this);
    }
}
