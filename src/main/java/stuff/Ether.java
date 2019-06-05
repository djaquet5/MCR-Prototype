package stuff;

import entity.Character;
import prototypal.Prototype;

public class Ether extends Item {

    public Ether() {
        super("Ether", "./icons/etherPotion.png");
    }

    public void heal(Character character){
        character.setMp((int) (character.getMp() * 0.5));
    }

    @Override
    public Prototype clonePrototype(){
        return new Ether();
    }
}
