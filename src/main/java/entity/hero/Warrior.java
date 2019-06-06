package entity.hero;

import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;

public class Warrior extends Hero {

    public Warrior() {
        super(100, 42, 450, 300, 42, 100, "PATH", 1, 0, 20, 0.2, 0.2, 0.9, 0.7, 0.1, 0.1);
        spellSlots.add(new Spell("War Cry", 10, 6));
        spellSlots.add(new Spell("Double Fists", 100, 21));
        spellSlots.add(new Spell("Exploooooooooosion", 40000, 666));
        inventory.put(new Ether(), 2);
    }

    @Override
    public Prototype clonePrototype() {
        return new Warrior();
    }
}
