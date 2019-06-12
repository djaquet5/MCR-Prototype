package stuff;

import entity.GameCharacter;
import prototypal.Prototype;

public class Potion extends Item {

    public Potion(){
        super("Potion", "src/icons/healthPotion.png");
    }

    @Override
    public void use(GameCharacter gameCharacter){
        gameCharacter.modifyHp((int) (gameCharacter.getMaxHp() * 0.5));
    }

    @Override
    public Prototype clonePrototype(){
        return new Potion();
    }
}
