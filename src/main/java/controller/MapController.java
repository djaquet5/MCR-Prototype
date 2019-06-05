package controller;

import entity.hero.Hero;
import entity.monster.Monster;
import maze.Donjon;
import prototypal.Prototype;
import stuff.Item;

import java.util.LinkedList;

public class MapController {
    private static int turn = 1;
    private Donjon donjon;

    private static LinkedList<Prototype> monsterAndStuff;
    private Hero hero;

    public static int getTurn(){
        return turn;
    }

    public void play(){
        while(true){
            /**
             * On bouge
             */
            /**
             * Les monstres bougent
             */
            for(Prototype p : monsterAndStuff){
                if(p instanceof Monster){
                    ((Monster) p).interactionDonjon(donjon);
                    if(hero.getPosition() == ((Monster) p).getPosition()){
                        battle(p);
                    }
                }else if(p instanceof Item && hero.getPosition() == ((Item) p).getPosition()){
                    hero.addToinventory((Item)p, 1);
                    removeFromGame(p);
                }
            }
            ++turn;
        }
    }

    public void battle(Prototype p){
        /**
         * On combat
         */
        if(((Monster) p).isDead()){
            removeFromGame(p);
        }
        if(hero.isDead()){
            /**
             * Game Over
             */
        }
    }

    public static void enterToGame(Prototype p){
        monsterAndStuff.add(p);
    }

    public static void removeFromGame(Prototype p){
        monsterAndStuff.remove(p);
    }
}
