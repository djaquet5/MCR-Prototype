package stuff;

import entity.GameCharacter;
import prototypal.Prototype;

public class Ether extends Item {

    public Ether() {
        super("Ether", "src/icons/etherPotion.png");
    }

    @Override
    public void use(GameCharacter gameCharacter){
        gameCharacter.modifyMp((int) (gameCharacter.getMaxMp() * 0.5));
    }

    @Override
    public Prototype clonePrototype(){
        return new Ether();
    }
}
