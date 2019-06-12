package entity.monster;

import controller.BattleController;
import controller.MapController;
import entity.hero.Hero;
import magic.Spell;
import maze.Dungeon;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Item;
import stuff.Potion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * Monster class that can summon other monsters
 */
public class Summoner extends Monster {

    private LinkedList<Monster> monsters;

    public Summoner() {
        super(280, 200, 150, 250, 55, 235, "src/monsters/Summoner/summoner.png", 90);
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
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(10)){
            case 0:
                Iterator<Map.Entry<Item, Integer>> items = inventory.entrySet().iterator();
                items.next();
                if(items.next().getValue() > 0) {
                    return BattleController.useItem(this, (inventory.entrySet().iterator().next()).getKey());
                }
            case 1:
            case 2:
            case 3:
                return BattleController.castSpell(this, getRandomSpell(), hero);
            case 4:
                if(inventory.entrySet().iterator().next().getValue() > 0) {
                    return BattleController.useItem(this, (inventory.entrySet().iterator().next()).getKey());
                }
            default:
                return BattleController.attack(this, hero);
        }
    }

    @Override
    public void interactionDonjon(Dungeon dj){
        if(MapController.getTurn() % 5 == 0){
            Random rand = new Random();
            Monster monstre = (Monster) monsters.get(rand.nextInt(monsters.size())).clonePrototype();
            monstre.initialize(dj.getRandomAdjacentReachableCell(this.getPosition()));
            MapController.enterMonsterToGame(monstre);
        }
    }

    @Override
    public Prototype clonePrototype(){
        return new Summoner();
    }
    
}
