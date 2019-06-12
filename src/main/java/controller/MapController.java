package controller;

import display.BattleMenu;
import display.Game;
import display.GameDisplayer;
import display.GameOver;
import entity.hero.Hero;
import entity.monster.Monster;
import maze.Dungeon;
import maze.ReachableCell;
import stuff.Item;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

public class MapController extends Thread{
    private static int turn = 1;
    private static Dungeon dungeon;

    private static LinkedList<Monster> monsters = new LinkedList<>();
    private static LinkedList<Item> items = new LinkedList<>();
    private static LinkedList<Monster> monstersGB = new LinkedList<>();
    private static LinkedList<Item> itemGB = new LinkedList<>();
    private static LinkedList<Monster> newMonsters = new LinkedList<>();
    private static Hero hero;

    private static Game game;

    public MapController(Hero hero, Dungeon dungeon){
        this.hero = hero;
        this.dungeon = dungeon;
        this.game = Game.getInstance();

        for(Monster p : newMonsters){
            monsters.add(p);
        }
        newMonsters.clear();
    }

    public static int getTurn(){
        return turn;
    }

    public static void move(ReachableCell cell){
        // move hero
        hero.setPosition(cell);

        //dicover cells
        discoverCells();
        processTurn();
    }

    private static void processTurn() {

        // clean up at the begining of every turn
        removeOldMonstersFromGame();
        removeOldItemsFromGame();
        monstersGB.clear();
        itemGB.clear();

        // Add monsters
        monsters.addAll(newMonsters);
        newMonsters.clear();
        for(Monster monster: monsters) {
            // Move monsters every 3 turns
            if(turn % 3 == 0) {
                monster.interactionDonjon(dungeon);
            }

            if(hero.getPosition() == monster.getPosition()){
                // If same cell initiate battle
                battle(monster);
            }
        }

        for(Item item: items) {
            if(hero.getPosition() == item.getPosition()) {
                // Collect item if on same cell
                hero.addToinventory((Item)item, 1);
                itemGB.add(item);
            }
        }

        ++turn;
    }

    public static void battle(Monster m){
        // On combat
        Game.getInstance().changePanel(new BattleMenu(m, hero).getBattlePanel());
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

    public static void enterMonsterToGame(Monster p){
        newMonsters.add(p);
    }

    public static void enterItemToGame(Item p){
        items.add(p);
    }

    private static void removeOldMonstersFromGame() {
        monsters.removeAll(monstersGB);
    }

    private static void removeOldItemsFromGame() {
        items.removeAll(itemGB);
    }

    public static Hero getHero(){
        return hero;
    }

    public static LinkedList<Monster> getMonsters(){
        return monsters;
    }

    public static LinkedList<Item> getItems() {
        return items;
    }

    public static Dungeon getDungeon(){
        return dungeon;
    }

    public static class Controls extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN || keyEvent.getKeyCode() == KeyEvent.VK_S) {
                System.out.println("Moved down");
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX(), MapController.getHero().getPosition().getPosY() + 1)){
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX(),
                            MapController.getHero().getPosition().getPosY() + 1));
                }
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_UP || keyEvent.getKeyCode() == KeyEvent.VK_W) {
                System.out.println("Moved up");
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX(), MapController.getHero().getPosition().getPosY() - 1)){
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX(),
                            MapController.getHero().getPosition().getPosY() - 1));
                }
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_D) {
                System.out.println("Moved right");
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX() + 1, MapController.getHero().getPosition().getPosY())){
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX() + 1,
                            MapController.getHero().getPosition().getPosY()));
                }
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_A) {
                System.out.println("Moved left");
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX() - 1, MapController.getHero().getPosition().getPosY())){
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX() - 1,
                            MapController.getHero().getPosition().getPosY()));
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }

    public static void signal(Monster m){
        Game.getInstance().changePanel(GameDisplayer.getInstance());
        if(m.isDead()){
            hero.gainExp(m.getExpPoint());
            monstersGB.add(m);
        }

        if(hero.isDead()){
            // Game Over
            game.setContentPane(new GameOver().getGameOverPanel());
        }
    }
}
