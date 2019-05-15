package maze;

import Stuff.Item;

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
    public Cell clone() {
        return new ReachableCell(this);
    }
}