package stuff;

import maze.ReachableCell;
import prototypal.Prototype;
import entity.GameCharacter;

public abstract class Item implements Prototype {
    private String nom;
    private String image;
    private ReachableCell position;

    public Item(String nom, String image){
        this.nom = nom;
        this.image = image;
    }

    public abstract void use(GameCharacter gameCharacter);

    public ReachableCell getPosition() {
        return position;
    }

    @Override
    public void initialize(ReachableCell cell) {
        this.position = cell;
    }
}
