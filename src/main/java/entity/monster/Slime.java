package entity.monster;

import controller.MapController;
import maze.Donjon;
import prototypal.Prototype;


public class Slime extends Monster{
    public Slime(){
        super(60, 20, 40, 180, 20, 10, "PATH", 10);
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
