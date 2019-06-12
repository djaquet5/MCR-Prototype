package display;

import controller.MapController;
import maze.ReachableCell;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame {

    private static  Game game;
    private Game() {
        setTitle("Prototype");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        setContentPane(new MainMenu().getMainPanel());
        addKeyListener(new KeyListener() {
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
        });
        setVisible(true);
        pack();
    }

    public void changePanel(JPanel panel){
        setContentPane(panel);
        repaint();
        revalidate();
    }

    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }
}
