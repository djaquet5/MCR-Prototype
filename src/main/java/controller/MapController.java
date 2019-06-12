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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

// TODO: Add gameEnabled boolean

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

    public MapController(Hero hero){
        this.hero = hero;
        this.game = Game.getInstance();

        monsters.addAll(newMonsters);
        newMonsters.clear();
    }

    public static int getTurn(){
        return turn;
    }

    public static void move(ReachableCell cell){

        // move hero
        hero.setPosition(cell);
        if(cell == dungeon.getEndCell()) {
            GameOver gameOver = new GameOver();
            gameOver.displayWin();
            game.changePanel(gameOver.getGameOverPanel());
            // TODO: finish game here
        }

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
                monster.dungeonInteraction(dungeon);
            }

            if(hero.getPosition() == monster.getPosition()){
                // If same cell initiate battle
                battle(monster);
            }
        }

        for(Item item: items) {
            if(hero.getPosition() == item.getPosition()) {
                // Collect item if on same cell
                hero.addToInventory(item, 1);
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

    public static void generate10x10Dungeon() {
        int[][] cells = new int[][]{
                {9, 7, 7, 1, 0, 0, 0, 1, 7, 8},
                {1, 2, 1, 1, 0, 0, 1, 1, 7, 8},
                {7, 1, 8, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 2, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 8, 0, 8, 1, 1, 4, 0},
                {0, 1, 3, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 2, 0, 1, 1, 1},
                {0, 4, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 7, 1, 1, 0, 1, 1, 6},
                {0, 7, 1, 5, 8, 1, 0, 10, 6, 0}
        };

        dungeon = new Dungeon(cells);
    }

    public static class Controls extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN || keyEvent.getKeyCode() == KeyEvent.VK_S) {
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX(), MapController.getHero().getPosition().getPosY() + 1)) {
                    System.out.println("Moved down");
                    MapController.getHero().setDisplayImagePath(getHero().getDisplayImageDown());
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX(),
                            MapController.getHero().getPosition().getPosY() + 1));
                }
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_UP || keyEvent.getKeyCode() == KeyEvent.VK_W) {
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX(), MapController.getHero().getPosition().getPosY() - 1)) {
                    System.out.println("Moved up");
                    MapController.getHero().setDisplayImagePath(getHero().getDisplayImageUp());
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX(),
                            MapController.getHero().getPosition().getPosY() - 1));
                }
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_D) {
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX() + 1, MapController.getHero().getPosition().getPosY())) {
                    System.out.println("Moved right");
                    MapController.getHero().setDisplayImagePath(getHero().getDisplayImageRight());
                    MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX() + 1,
                            MapController.getHero().getPosition().getPosY()));
                }
            }
            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_A) {
                if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX() - 1, MapController.getHero().getPosition().getPosY())){
                    System.out.println("Moved left");
                    MapController.getHero().setDisplayImagePath(getHero().getDisplayImageLeft());
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
