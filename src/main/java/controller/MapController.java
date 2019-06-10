package controller;

import display.Game;
import display.GameOver;
import entity.hero.Hero;
import entity.monster.Monster;
import maze.Dungeon;
import maze.ReachableCell;
import prototypal.Prototype;
import stuff.Item;

import java.util.LinkedList;

public class MapController{
    private static int turn = 1;
    private static Dungeon dungeon;

    private static LinkedList<Prototype> monsterAndStuff;

    static {
        monsterAndStuff = new LinkedList<>();
    }

    ;
    private static Hero hero;

    public MapController(Hero hero, Dungeon dungeon){
        this.hero = hero;
        this.dungeon = dungeon;
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
        discoverCells();

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
            Game.getInstance().setContentPane(new GameOver().getGameOverPanel());

        }
    }

    public static void discoverCells(){
        for(int x = -1; x <= 1; ++x){
            for(int y = -1; y <= 1; ++y){
                if(hero.getPosition().getPosX() + x >= 0 && hero.getPosition().getPosX() + x < dungeon.getMaxX() &&
                        hero.getPosition().getPosY() + y >= 0 && hero.getPosition().getPosY() + y < dungeon.getMaxY()) {
                    dungeon.getCell(hero.getPosition().getPosX() + x, hero.getPosition().getPosY() + y).discover();
                }
            }
        }
    }

    public static void enterToGame(Prototype p){
        System.out.println(monsterAndStuff.size());
        monsterAndStuff.add(p);
    }

    public static void removeFromGame(Prototype p){
        monsterAndStuff.remove(p);
    }

    public static Hero getHero(){ return hero;}

    public static LinkedList<Prototype> getMonsterAndStuff(){return monsterAndStuff;}

    public static Dungeon getDungeon(){return dungeon;}
}
