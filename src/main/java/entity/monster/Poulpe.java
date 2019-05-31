package entity.monster;

import prototypal.Prototype;

public class Poulpe extends Monster {
    public Poulpe() {
        super(65, 65, 75, 75, 40, 40, "PATH", 33);
    }

    @Override
    public Prototype clonePrototype() {
        return new Poulpe();
    }
}
