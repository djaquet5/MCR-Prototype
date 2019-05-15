package entity;

/**
 * Monster class that can summon other monsters
 */
public class Summoner extends Monster {

    private Monster prototype;

    public Summoner(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
    }
}
