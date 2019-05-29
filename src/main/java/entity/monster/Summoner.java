package entity.monster;

import maze.ReachableCell;

/**
 * Monster class that can summon other monsters
 */
public class Summoner extends Monster {

    private Monster prototype;

    public Summoner() {
        super(280, 200, 150, 250, 55, 235, "PATH", 90);
    }

    @Override
    public Monster clone(){
        return new Summoner();
    }
    
}
