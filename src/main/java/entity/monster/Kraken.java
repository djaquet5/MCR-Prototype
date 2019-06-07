package entity.monster;

import controller.BattleController;
import entity.hero.Hero;
import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Item;
import stuff.Potion;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Kraken extends Monster {

    public Kraken() {
        super(330, 123, 220, 200, 99, 200, "PATH", 137);
        spellSlots.add(new Spell("Frozzen Breath", 88, 20));
        spellSlots.add(new Spell("Bubble Cramble", 33, 3));
        spellSlots.add(new Spell("Death Anchor", 55, 10));
        inventory.put(new Ether(), 2);
        inventory.put(new Potion(), 3);
    }

    @Override
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(10)){
            case 0:
                if(inventory.entrySet().iterator().next().getValue() > 0) {
                    return BattleController.useItem(this, inventory.entrySet().iterator().next().getKey());
                }
            case 1:
            case 2:
            case 3:
            case 4:
                return BattleController.castSpell(this, getRandomSpell(), hero);
            case 5:
                Iterator<Map.Entry<Item, Integer>> items = inventory.entrySet().iterator();
                items.next();
                if(items.next().getValue() > 0) {
                    return BattleController.useItem(this, (inventory.entrySet().iterator().next()).getKey());
                }
            default:
                return BattleController.attack(this, hero);
        }
    }

    @Override
    public Prototype clonePrototype() {
        return new Kraken();
    }
}
