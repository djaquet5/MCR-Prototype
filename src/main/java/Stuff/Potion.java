package Stuff;

import Person.Character;

public class Potion extends Item {

    public Potion(){
        super("Potion", "PATH");
    }

    public void heal(Character character){
        character.setHp((int) (character.getHp() * 0.5));
    }

    @Override
    public Item clone(){
        return new Potion();
    }
}
