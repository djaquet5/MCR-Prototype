package display;

import javax.swing.*;
import java.awt.*;
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

    private void setGameOverTextArea(String message) {
        gameOverTextArea.setText(message);
    }

    private void setBackGround(Color color) {
        gameOverTextArea.setBackground(color);
        gameOverPanel.setBackground(color);
    }

    public void displayWin() {
        setBackGround(new Color(255,105,180));
        setGameOverTextArea("You win!");
    }


}
