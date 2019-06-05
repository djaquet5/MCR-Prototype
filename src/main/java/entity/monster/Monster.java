package entity.monster;

import entity.GameCharacter;
import maze.Donjon;
import maze.ReachableCell;

public abstract class Monster extends GameCharacter {

    int expPoint;

    public Monster(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage, int expPoint) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
        this.expPoint = expPoint;
    }

    public void interactionDonjon(Donjon dj){
        ReachableCell rc = dj.getRandomAdjacentReachableCell(this.getPosition());
        setPosition(rc);
    }

    public int getExpPoint(){
        return expPoint;
    }

}
