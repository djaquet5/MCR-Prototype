package display;

import controller.MapController;

import javax.swing.*;

public class Game extends JFrame {

    private static  Game game;
    private Game() {
        setTitle("Prototype");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        setContentPane(new MainMenu().getMainPanel());
        addKeyListener(new MapController.Controls());
        setVisible(true);
        pack();
    }

    public void changePanel(JPanel panel){
        getContentPane().removeAll();
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

    public static void resetGame(){
        game = null;
    }
}
