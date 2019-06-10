package entity.monster;

import controller.BattleController;
import entity.hero.Hero;
import magic.Spell;
import prototypal.Prototype;
import stuff.Potion;

import java.util.Random;

public class Squid extends Monster {
    public Squid() {
        super(65, 65, 40, 40, 75, 75, "src/monsters/Squid/squid.png", 33);
        spellSlots.add(new Spell("Ink Trow", 55, 10));
        spellSlots.add(new Spell("Suction Pad", 20, 5));
        inventory.put(new Potion(), 1);
    }

    @Override
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(6)){
            case 0:
            case 1:
                return BattleController.attack(this, hero);

            case 2:
                if(inventory.entrySet().iterator().next().getValue() > 0) {
                    return BattleController.useItem(this, inventory.entrySet().iterator().next().getKey());
                }
            default:
                return BattleController.castSpell(this, getRandomSpell(), hero);
        }
    }

    @Override
    public Prototype clonePrototype() {
        return new Squid();
    }
}
