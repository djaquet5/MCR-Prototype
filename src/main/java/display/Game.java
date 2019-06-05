package display;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    Game() {
        setTitle("Prototype");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new GameDisplayer());
        pack();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
