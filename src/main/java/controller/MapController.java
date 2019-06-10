package controller;

import display.GameDisplayer;
import entity.hero.Hero;
import entity.monster.Monster;
import entity.monster.Slime;
import maze.Dungeon;
import maze.ReachableCell;
import prototypal.Prototype;
import stuff.Item;

import java.util.LinkedList;

public class MapController{
    private static int turn = 1;
    private static Dungeon dungeon;

    private static LinkedList<Prototype> monsterAndStuff;
    private static Hero hero;

    private GameDisplayer gameDisplayer;

    private Monster testMonster;

    public MapController(Hero hero, Dungeon dungeon){
        this.hero = hero;
        this.dungeon = dungeon;
        // TODO: initialize hero and dungeon
        this.gameDisplayer = new GameDisplayer();
        this.testMonster = new Slime();
    }

    public static int getTurn(){
        return turn;
    }

    public static void move(ReachableCell cell){
        /**
         * On bouge
         */
        hero.setPosition(cell);
        /**
         * On découvre les cases autour de nous
         */
        for(int x = -1; x <= 1; ++x){
            for(int y = -1; y <= 1; ++y){
                dungeon.getCell(hero.getPosition().getPosX() + x, hero.getPosition().getPosY() + y).discover();
            }
        }

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

    public static void battle(Prototype p){
        /**
         * On combat
         */
        if(((Monster) p).isDead()){
            hero.gainExp(((Monster) p).getExpPoint());
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

    public static Hero getHero(){ return hero;}

    public static LinkedList<Prototype> getMonsterAndStuff(){return monsterAndStuff;}

    public static Dungeon getDungeon(){return dungeon;}

    public GameDisplayer getGameDisplayer() {
        return gameDisplayer;
    }
}
