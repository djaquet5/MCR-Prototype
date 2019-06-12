package display;

import javax.swing.*;
import javax.swing.plaf.metal.MetalComboBoxButton;
import java.awt.event.*;

public class GameOver {
    private JTextArea gameOverTextArea;
    private JPanel gameOverPanel;

    public GameOver(){
        gameOverPanel.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Game.getInstance().setContentPane(new MainMenu().getMainPanel());
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) { }
        });

        Game.resetGame();
    }

    public JPanel getGameOverPanel(){
        return gameOverPanel;
    }
}
