package stuff;

import maze.ReachableCell;
import prototypal.Prototype;
import entity.Character;

public abstract class Item implements Prototype {
    private String nom;
    private String image;

    public Item(String nom, String image){
        this.nom = nom;
        this.image = image;
    }

    public abstract void heal(Character character);
}
