package entity.monster;

import magic.Spell;
import prototypal.Prototype;

public class Calamar extends Monster {
    public Calamar() {
        super(65, 65, 40, 40, 75, 75, "PATH", 33);
        spellSlots.add(new Spell("Ink Trow", 55, 10));
        spellSlots.add(new Spell("Suction Pad", 20, 5));
    }

    @Override
    public Prototype clonePrototype() {
        return new Calamar();
    }
}
