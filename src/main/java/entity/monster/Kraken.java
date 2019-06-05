package entity.monster;

import prototypal.Prototype;

public class Kraken extends Monster {

    public Kraken() {
        super(330, 123, 220, 200, 99, 200, "PATH", 137);
    }

    @Override
    public Prototype clonePrototype() {
        return new Kraken();
    }
}
