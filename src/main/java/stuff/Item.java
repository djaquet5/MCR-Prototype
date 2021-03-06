package stuff;

import controller.MapController;
import maze.Cell;
import prototypal.Prototype;
import entity.GameCharacter;

public abstract class Item implements Prototype {
    private String name;
    private String image;
    private Cell position;

    public Item(String name, String image){
        this.name = name;
        this.image = image;
    }

    public Item(Item item) {
        this.name = item.name;
        this.image = item.image;
    }

    public abstract void use(GameCharacter gameCharacter);

    @Override
    public Cell getPosition() {
        return position;
    }

    @Override
    public String getDisplayImagePath(){
        return image;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void initialize(Cell cell) {
        this.position = cell;
        MapController.enterItemToGame(this);
    }
}
