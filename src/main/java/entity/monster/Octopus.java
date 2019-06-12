package entity.monster;

import controller.BattleController;
import entity.hero.Hero;
import magic.Spell;
import prototypal.Prototype;
import stuff.Potion;

import java.util.Map;
import java.util.Random;

public class Octopus extends Monster {
    public Octopus() {
        super(65, 65, 75, 75, 40, 40, "src/monsters/Octopus/octopus.png", 33);
        spellSlots.add(new Spell("Round Ball", 55, 10));
        spellSlots.add(new Spell("Ignition Ink", 30, 5));
        addToInventory(new Potion(), 1);
    }

    @Override
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(6)){
            case 0:
            case 1:
                return BattleController.castSpell(this, getRandomSpell(), hero);
            case 2:
                if(inventory.size() > 0) {
                    return BattleController.useItem(this, inventory.get(0));
                }
            default:
                 return BattleController.attack(this, hero);
        }
    }

    @Override
    public Prototype clonePrototype() {
        return new Octopus();
    }
}
