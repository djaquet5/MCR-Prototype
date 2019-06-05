package stuff;

import entity.GameCharacter;
import prototypal.Prototype;

public class Ether extends Item {

    public Ether() {
        super("Ether", "./icons/etherPotion.png");
    }

    @Override
    public void use(GameCharacter gameCharacter){
        gameCharacter.setMp((int) (gameCharacter.getMp() * 0.5));
    }

    @Override
    public Prototype clonePrototype(){
        return new Ether();
    }
}
