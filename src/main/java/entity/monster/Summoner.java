package entity.monster;

import controller.MapController;
import magic.Spell;
import maze.Donjon;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Potion;

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
        spellSlots.add(new Spell("Thunder Shock", 88, 25));
        spellSlots.add(new Spell("Fire Whip", 66, 20));
        spellSlots.add(new Spell("Icy Wind", 30, 5));
        spellSlots.add(new Spell("Spectral Inferno", 102, 30));
        inventory.put(new Ether(), 2);
        inventory.put(new Potion(), 1);
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
