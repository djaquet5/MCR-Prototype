package stuff;

import entity.Character;

public class Potion extends Item {

    public Potion(){
        super("Potion", "./icons/healthPotion.png");
    }

    public void heal(Character character){
        character.setHp((int) (character.getHp() * 0.5));
    }

    @Override
    public Item clone(){
        return new Potion();
    }
}
