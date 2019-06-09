package stuff;

import maze.Cell;
import prototypal.Prototype;
import entity.Character;

public abstract class Item implements Prototype {
    private String nom;
    private String image;
    private Cell position;

    public Item(String nom, String image){
        this.nom = nom;
        this.image = image;
    }

    public abstract void heal(Character character);

    public Cell getPosition() {
        return position;
    }

    @Override
    public void initialize(Cell cell) {
        this.position = cell;
    }
}
