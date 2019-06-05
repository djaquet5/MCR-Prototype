package maze;

import display.GameDisplayer;
import stuff.Item;

import java.awt.*;
import java.util.LinkedList;

public class ReachableCell extends Cell {
    private LinkedList<Character> characters;
    private Item item;
    public ReachableCell(ReachableCell rc) {
        super(rc);
    }

    public void addItem(Item item){
       this.item = item;
    }

    public void removeItem(){
        this.item = null;
    }

    public void addCharacter(Character character){
        characters.add(character);
    }

    public void removeCharacter(Character character){
        characters.remove(character);
    }

    @Override
    public void draw(Graphics2D g, GameDisplayer observer) {
        g.drawImage(GameDisplayer.STONE, 5 + getPosX() * 100, 5 + getPosY() * 100, 90, 90, observer);
    }

    @Override
    public Cell clone() {
        return new ReachableCell(this);
    }
}