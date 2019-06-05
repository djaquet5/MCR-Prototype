package entity.monster;

import magic.Spell;
import prototypal.Prototype;

public class Kraken extends Monster {

    public Kraken() {
        super(330, 123, 220, 200, 99, 200, "PATH", 137);
        spellSlots.add(new Spell("Frozzen Breath", 88, 20));
        spellSlots.add(new Spell("Bubble Cramble", 33, 3));
        spellSlots.add(new Spell("Death Anchor", 55, 10));
    }

    @Override
    public Prototype clonePrototype() {
        return new Kraken();
    }
}
