package entity.monster;

import controler.MapControler;
import maze.Cell;
import maze.Donjon;
import maze.ReachableCell;

import java.util.LinkedList;
import java.util.Random;

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
        if(MapControler.getTurn() % 13 == 0){

            Slime slime = (Slime)this.clone();
            slime.initialize( dj.getRandomAdjacentReachableCell(this.getPosition()));

        }else{
            super.interactionDonjon(dj);
        }
    }

    @Override
    public Monster clone(){
        return new Slime();
    }
}
