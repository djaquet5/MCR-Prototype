package entity.monster;

import controller.MapController;
import maze.Donjon;
import prototypal.Prototype;

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
        monsters.add(new Octopus());
        monsters.add(new Squid());
    }

    @Override
    public void interactionDonjon(Donjon dj){
        if(MapController.getTurn() % 5 == 0){
            Random rand = new Random();
            Prototype monstre = monsters.get(rand.nextInt(monsters.size())).clonePrototype();
            monstre.initialize(dj.getRandomAdjacentReachableCell(this.getPosition()));
            MapController.enterToGame(monstre);
        }
    }

    @Override
    public Prototype clonePrototype(){
        return new Summoner();
    }
    
}
