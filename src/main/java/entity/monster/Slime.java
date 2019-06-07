package entity.monster;

import controller.BattleController;
import controller.MapController;
import entity.hero.Hero;
import magic.Spell;
import maze.Donjon;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Item;
import stuff.Potion;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class Slime extends Monster{
    public Slime(){
        super(60, 20, 40, 180, 20, 10, "PATH", 10);
        spellSlots.add(new Spell("Acid Body", 40, 4));
        inventory.put(new Potion(), 1);
        inventory.put(new Ether(), 1);
    }

    /**
     * Se dédouble tous les 5 tours
     * @param dj Le donjon en question
     */
    @Override
    public void interactionDonjon(Donjon dj){
        if(MapController.getTurn() % 13 == 0){
            Prototype slime = this.clonePrototype();
            slime.initialize( dj.getRandomAdjacentReachableCell(this.getPosition()));

        }else{
            super.interactionDonjon(dj);
        }
    }

    @Override
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(8)){
            case 0:
                Iterator<Map.Entry<Item, Integer>> items = inventory.entrySet().iterator();
                if(items.next().getValue() > 0) {
                    return BattleController.useItem(this, inventory.entrySet().iterator().next().getKey());
                }
                if(items.next().getValue() > 0) {
                    return BattleController.useItem(this, (inventory.entrySet().iterator().next()).getKey());
                }
            case 1:
            case 2:
                return BattleController.attack(this, hero);
            default:
                return BattleController.castSpell(this, getRandomSpell(), hero);
        }
    }

    @Override
    public Prototype clonePrototype(){
        return new Slime();
    }
}
