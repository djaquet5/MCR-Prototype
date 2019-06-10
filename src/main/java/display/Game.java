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
            public void keyTyped(KeyEvent keyEvent) {
                if ('s' == keyEvent.getKeyChar()) {
                    System.out.println("Moved down");
                    if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX(), MapController.getHero().getPosition().getPosY() + 1)){
                        MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX(),
                                MapController.getHero().getPosition().getPosY() + 1));
                    }
                }
                if ('w' == keyEvent.getKeyChar()) {
                    System.out.println("Moved up");
                    if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX(), MapController.getHero().getPosition().getPosY() - 1)){
                        MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX(),
                                MapController.getHero().getPosition().getPosY() - 1));
                    }
                }
                if ('d' == keyEvent.getKeyChar()) {
                    System.out.println("Moved right");
                    System.out.println(MapController.getHero());
                    System.out.println(MapController.getHero());
                    if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX() + 1, MapController.getHero().getPosition().getPosY())){
                        MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX() + 1,
                                MapController.getHero().getPosition().getPosY()));
                    }
                }
                if ('a' == keyEvent.getKeyChar()) {
                    System.out.println("Moved left");
                    if(MapController.getDungeon().isReachable(MapController.getHero().getPosition().getPosX() - 1, MapController.getHero().getPosition().getPosY())){
                        MapController.move((ReachableCell) MapController.getDungeon().getCell(MapController.getHero().getPosition().getPosX() - 1,
                                MapController.getHero().getPosition().getPosY()));
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
        game = this;
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
