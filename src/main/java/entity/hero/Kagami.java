package entity.hero;

import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Potion;

public class Kagami extends Hero {

    public Kagami() {
        super(100, 100, 400, 300, 250, 250, "src/Characters/DM1/face-stand.png",0.2, 0.3, 0.4, 0.5, 0.2, 0.3);
        spellSlots.add(new Spell("Kintama Crusher", 40, 1));
        spellSlots.add(new Spell("Winter Storm", 60, 10));
        spellSlots.add(new Spell("Rage", 70, 15));
        spellSlots.add(new Spell("Magnet Pulse", 80, 20));
        spellSlots.add(new Spell("Exploooooooooosion", 40000, 666));
        addToInventory(new Potion(), 1);
        addToInventory(new Ether(), 1);
    }

    @Override
    public Prototype clonePrototype() {
        return new Kagami();
    }
}
