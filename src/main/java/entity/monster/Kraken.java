package entity.monster;

import controller.BattleController;
import entity.hero.Hero;
import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Item;
import stuff.Potion;

import java.util.Random;

public class Kraken extends Monster {

    public Kraken() {
        super(330, 123, 220, 200, 99, 200, "src/monsters/Kraken/kraken.png", 137);
        spellSlots.add(new Spell("Frozzen Breath", 88, 20));
        spellSlots.add(new Spell("Bubble Cramble", 33, 3));
        spellSlots.add(new Spell("Death Anchor", 55, 10));
        addToInventory(new Ether(), 2);
        addToInventory(new Potion(), 3);
    }

    @Override
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(10)){
            case 0:
            case 1:
                if(inventory.size() > 0) {
                    return BattleController.useItem(this, inventory.get(rand.nextInt(inventory.size())));
                }
            case 2:
            case 3:
            case 4:
            case 5:
                return BattleController.castSpell(this, getRandomSpell(), hero);
            default:
                return BattleController.attack(this, hero);
        }
    }

    @Override
    public Prototype clonePrototype() {
        return new Kraken();
    }
}
