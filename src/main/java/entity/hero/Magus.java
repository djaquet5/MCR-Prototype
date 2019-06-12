package entity.hero;

import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Potion;

public class Magus extends Hero {

    public Magus() {
        super(100, 333, 40, 150, 300, 400, "src/Characters/DM3/face-stand.png", 0.2, 0.8, 0.1, 0.5, 0.5, 0.5);
        spellSlots.add(new Spell("Shadow Ball", 50, 10));
        spellSlots.add(new Spell("Ice Spear", 72, 15));
        spellSlots.add(new Spell("Thunder Storm", 100, 25));
        spellSlots.add(new Spell("Fire Wheel", 110, 30));
        spellSlots.add(new Spell("Gravity", 180, 40));
        spellSlots.add(new Spell("Meteor", 260, 100));
        spellSlots.add(new Spell("Exploooooooooosion", 40000, 666));
        addToInventory(new Ether(), 2);
    }

    @Override
    public Prototype clonePrototype() {
        return new Magus();
    }
}
