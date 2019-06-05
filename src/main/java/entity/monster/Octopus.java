package entity.monster;

import prototypal.Prototype;

public class Octopus extends Monster {
    public Octopus() {
        super(65, 65, 75, 75, 40, 40, "PATH", 33);
    }

    @Override
    public Prototype clonePrototype() {
        return new Octopus();
    }
}
