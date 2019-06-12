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

import java.util.Random;


public class Slime extends Monster{
    public Slime(){
        super(60, 20, 40, 180, 20, 10, "src/monsters/Slime/slime.png", 10);
        spellSlots.add(new Spell("Acid Body", 40, 4));
        addToInventory(new Potion(), 1);
        addToInventory(new Ether(), 1);
    }

    /**
     * Se dédouble tous les 5 tours
     * @param dj Le donjon en question
     */
    @Override
    public void dungeonInteraction(Dungeon dj){
        if(MapController.getTurn() % 12 == 0){
            Prototype slime = this.clonePrototype();
            slime.initialize( dj.getRandomAdjacentReachableCell(this.getPosition()));
        }else{
            super.dungeonInteraction(dj);
        }
    }

    @Override
    public String randomMove(Hero hero){
        Random rand = new Random();
        switch (rand.nextInt(8)){
            case 0:
                if(inventory.size() > 0) {
                    return BattleController.useItem(this, inventory.get(rand.nextInt(inventory.size())));
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
