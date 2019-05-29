package entity.monster;

import entity.Character;

public abstract class Monster extends Character {

    int expPoint;

    public Monster(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage, int expPoint) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
        this.expPoint = expPoint;
    }

    public int getExpPoint(){
        return expPoint;
    }

}