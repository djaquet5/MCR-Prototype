package entity.hero;

import magic.Spell;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Potion;

public class Warrior extends Hero {

    public Warrior() {
        super(100, 42, 450, 300, 42, 100, "src/Characters/DM2/face-stand.png", 0.2, 0.2, 0.9, 0.7, 0.1, 0.1);
        spellSlots.add(new Spell("War Cry", 10, 6));
        spellSlots.add(new Spell("Double Fists", 100, 21));
        spellSlots.add(new Spell("Exploooooooooosion", 40000, 666));
        addToInventory(new Potion(), 2);
    }

    @Override
    public Prototype clonePrototype() {
        return new Warrior();
    }

    @Override
    public String getDisplayImageDown() {
        return "src/Characters/DM2/face-stand.png";
    }

    @Override
    public String getDisplayImageUp() {
        return "src/Characters/DM2/back-stand.png";
    }

    @Override
    public String getDisplayImageRight() {
        return "src/Characters/DM2/right-stand.png";
    }

    @Override
    public String getDisplayImageLeft() {
        return "src/Characters/DM2/left-stand.png";
    }
}
