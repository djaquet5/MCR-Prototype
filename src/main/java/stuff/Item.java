package stuff;

import maze.ReachableCell;
import prototypal.Prototype;
import entity.GameCharacter;

public abstract class Item implements Prototype {
    private String name;
    private String image;
    private ReachableCell position;

    public Item(String name, String image){
        this.name = name;
        this.image = image;
    }

    public abstract void use(GameCharacter gameCharacter);

    public ReachableCell getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void initialize(ReachableCell cell) {
        this.position = cell;
    }
}
