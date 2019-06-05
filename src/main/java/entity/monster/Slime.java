package entity.monster;

import controller.MapController;
import magic.Spell;
import maze.Donjon;
import prototypal.Prototype;
import stuff.Ether;
import stuff.Potion;


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
    public Prototype clonePrototype(){
        return new Slime();
    }
}
