package display;

import controller.MapController;
import entity.hero.Hero;
import maze.Dungeon;
import maze.ReachableCell;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame {

    private Hero hero;
    private Dungeon dj;

    public Game() {
        hero = MapController.getHero();
        dj = MapController.getDungeon();
        setTitle("Prototype");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        setContentPane(new MainMenu(this).getMainPanel());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println(keyEvent.getKeyChar());
                if ('s' == keyEvent.getKeyChar()) {
                    System.out.println("Moved down");
                    if(dj.isReachable(hero.getPosition().getPosX(), hero.getPosition().getPosY() - 1)){
                        MapController.move((ReachableCell) dj.getCell(hero.getPosition().getPosX(),
                                hero.getPosition().getPosY() - 1));
                    }
                }
                if ('w' == keyEvent.getKeyChar()) {
                    System.out.println("Moved up");
                    if(dj.isReachable(hero.getPosition().getPosX(), hero.getPosition().getPosY() + 1)){
                        MapController.move((ReachableCell) dj.getCell(hero.getPosition().getPosX(),
                                hero.getPosition().getPosY() + 1));
                    }
                }
                if ('d' == keyEvent.getKeyChar()) {
                    System.out.println("Moved right");
                    if(dj.isReachable(hero.getPosition().getPosX() + 1, hero.getPosition().getPosY())){
                        MapController.move((ReachableCell) dj.getCell(hero.getPosition().getPosX() + 1,
                                hero.getPosition().getPosY()));
                    }
                }
                if ('a' == keyEvent.getKeyChar()) {
                    System.out.println("Moved left");
                    if(dj.isReachable(hero.getPosition().getPosX() - 1, hero.getPosition().getPosY())){
                        MapController.move((ReachableCell) dj.getCell(hero.getPosition().getPosX() - 1,
                                hero.getPosition().getPosY()));
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        setVisible(true);
        pack();
    }

    public void changePanel(JPanel panel){
        setContentPane(panel);
        repaint();
        revalidate();
    }
}
