package entity.monster;

import entity.GameCharacter;
import entity.hero.Hero;
import magic.Spell;
import maze.Cell;
import maze.Dungeon;

import java.util.Random;

public abstract class Monster extends GameCharacter {

    private int expPoint;

    public Monster(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage, int expPoint) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
        this.expPoint = expPoint;
    }

    public void interactionDonjon(Dungeon dj){
        Cell rc = dj.getRandomAdjacentReachableCell(getPosition());
        setPosition(rc);
    }

    public abstract String randomMove(Hero hero);

    public int getExpPoint(){
        return expPoint;
    }

    protected Spell getRandomSpell(){
        Random rand = new Random();
        return spellSlots.get(rand.nextInt(spellSlots.size()));
    }

}
