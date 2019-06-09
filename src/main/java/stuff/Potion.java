package stuff;

import entity.GameCharacter;
import prototypal.Prototype;

public class Potion extends Item {

    public Potion(){
        super("Potion", "./icons/healthPotion.png");
    }

    @Override
    public void use(GameCharacter gameCharacter){
        gameCharacter.setHp((int) (gameCharacter.getHp() * 0.5));
    }

    @Override
    public Prototype clonePrototype(){
        return new Potion();
    }
}
