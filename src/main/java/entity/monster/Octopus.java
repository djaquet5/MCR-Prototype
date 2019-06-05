package entity.monster;

import magic.Spell;
import prototypal.Prototype;
import stuff.Potion;

public class Octopus extends Monster {
    public Octopus() {
        super(65, 65, 75, 75, 40, 40, "PATH", 33);
        spellSlots.add(new Spell("Round Ball", 55, 10));
        spellSlots.add(new Spell("Ignition Ink", 30, 5));
        inventory.put(new Potion(), 1);
    }

    @Override
    public Prototype clonePrototype() {
        return new Octopus();
    }
}
