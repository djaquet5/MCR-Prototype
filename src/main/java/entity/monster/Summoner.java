package entity.monster;

import controler.MapControler;
import maze.Donjon;
import maze.ReachableCell;

import java.util.LinkedList;
import java.util.Random;

/**
 * Monster class that can summon other monsters
 */
public class Summoner extends Monster {

    private LinkedList<Monster> monsters;

    public Summoner() {
        super(280, 200, 150, 250, 55, 235, "PATH", 90);
        monsters = new LinkedList<>();
        monsters.add(new Slime());
    }

    @Override
    public void interactionDonjon(Donjon dj){
        if(MapControler.getTurn() % 5 == 0){
            Random rand = new Random();
            Monster monstre = monsters.get(rand.nextInt(monsters.size())).clone();
        }
    }

    @Override
    public Monster clone(){
        return new Summoner();
    }
    
}
