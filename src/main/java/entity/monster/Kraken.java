package entity.monster;

import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Potion;

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
    public Prototype clonePrototype() {
        return new Kraken();
    }
}
