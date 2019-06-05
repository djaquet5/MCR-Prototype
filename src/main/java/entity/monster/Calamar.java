package entity.monster;

import prototypal.Prototype;

public class Calamar extends Monster {
    public Calamar() {
        super(65, 65, 40, 40, 75, 75, "PATH", 33);

    }

    @Override
    public Prototype clonePrototype() {
        return new Calamar();
    }
}
