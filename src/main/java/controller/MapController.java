package controller;

import display.BattleMenu;
import display.Game;
import display.GameDisplayer;
import display.GameOver;
import entity.hero.Hero;
import entity.monster.Monster;
import maze.Dungeon;
import maze.ReachableCell;
import prototypal.Prototype;
import stuff.Item;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;

public class MapController extends Thread{
    private static int turn = 1;
    private static Dungeon dungeon;

    private static LinkedList<Prototype> monsterAndStuff = new LinkedList<>();
    private static LinkedList<Prototype> victor = new LinkedList<>();
    private static LinkedList<Prototype> newMonsters = new LinkedList<>();
    private static Hero hero;

    private static final Object LOCK = new Object() {};

    private static Game game;

    public MapController(Hero hero, Dungeon dungeon){
        this.hero = hero;
        this.dungeon = dungeon;
        this.game = Game.getInstance();

        for(Prototype p : newMonsters){
            monsterAndStuff.add(p);
        }
        newMonsters.clear();
    }

    public static int getTurn(){
        return turn;
    }

    public static void move(ReachableCell cell){
        // On bouge
        hero.setPosition(cell);

        // On découvre les cases autour de nous
        discoverCells();

        for(Prototype p : monsterAndStuff){
            if(p instanceof Monster){
                // Les monstres bougent
                ((Monster) p).interactionDonjon(dungeon);

                if(hero.getPosition() == p.getPosition()){
                    // Si même case, combat
                    battle((Monster) p);
                }
            } else if(p instanceof Item && hero.getPosition() == p.getPosition()){
                // On ramasse les items sur la même case que nous
                hero.addToinventory((Item)p, 1);
                victor.add(p);
            }
        }

        // On supprime les morts
        for(Prototype p : victor){
            removeFromGame(p);
        }
        victor.clear();

        // On rajoute les monstres
        for(Prototype p : newMonsters){
            monsterAndStuff.add(p);
        }
        newMonsters.clear();

        ++turn;
    }

    public static void battle(Monster m){
        // On combat
        System.out.println("Battle");
        game.setEnabled(false);

        JFrame battle = new JFrame("Battle");
        battle.setSize(650, 480);
        BattleMenu menu = new BattleMenu(m, hero);
        battle.add(menu.getBattlePanel());
        battle.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                game.setEnabled(true);
            }
        });
        battle.setVisible(true);

        if(m.isDead()){
            hero.gainExp(m.getExpPoint());
            victor.add(m);
        }

        if(hero.isDead()){
            // Game Over
            game.setContentPane(new GameOver().getGameOverPanel());
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
        newMonsters.add(p);
    }

    public static void removeFromGame(Prototype p){
        monsterAndStuff.remove(p);
    }

    public static Hero getHero(){
        return hero;
    }

    public static LinkedList<Prototype> getMonsterAndStuff(){
        return monsterAndStuff;
    }

    public static Dungeon getDungeon(){
        return dungeon;
    }

    public static void signal(){
        synchronized (LOCK){
            LOCK.notify();
        }
    }
}
