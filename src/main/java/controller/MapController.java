package controller;

import entity.hero.Hero;
import entity.monster.Monster;
import maze.Dungeon;
import maze.ReachableCell;
import prototypal.Prototype;
import stuff.Item;

import java.util.LinkedList;

public class MapController {
    private static int turn = 1;
    private Dungeon dungeon;

    private static LinkedList<Prototype> monsterAndStuff;
    private Hero hero;

    public MapController(Hero hero, Dungeon donjon){
        this.hero = hero;
        this.dungeon = donjon;
    }

    public static int getTurn(){
        return turn;
    }

    public void play(){
        while(true){



        }
    }

    public void move(ReachableCell cell){
        /**
         * On bouge
         */
        hero.setPosition(cell);

        for(Prototype p : monsterAndStuff){
            if(p instanceof Monster){
                /**
                 * Les monstres bougent
                 */
                ((Monster) p).interactionDonjon(dungeon);
                if(hero.getPosition() == ((Monster) p).getPosition()){
                    /**
                     * Si même case, combat
                     */
                    battle(p);
                }
            }else if(p instanceof Item && hero.getPosition() == ((Item) p).getPosition()){
                /**
                 * On ramasse les items sur la même case que nous
                 */
                hero.addToinventory((Item)p, 1);
                removeFromGame(p);
            }
        }
        ++turn;
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