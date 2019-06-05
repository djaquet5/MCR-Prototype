package entity.monster;

import magic.Spell;
import prototypal.Prototype;
import stuff.Potion;

public class Squid extends Monster {
    public Squid() {
        super(65, 65, 40, 40, 75, 75, "PATH", 33);
        spellSlots.add(new Spell("Ink Trow", 55, 10));
        spellSlots.add(new Spell("Suction Pad", 20, 5));
        inventory.put(new Potion(), 1);
    }

    @Override
    public Prototype clonePrototype() {
        return new Squid();
    }
}
