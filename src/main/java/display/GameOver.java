package display;

import javax.swing.*;
import javax.swing.plaf.metal.MetalComboBoxButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameOver  implements KeyListener {
    private JTextArea gameOverTextArea;
    private JPanel gameOverPanel;

    private void createUIComponents() {}

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        Game.getInstance().setContentPane(new MainMenu().getMainPanel());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}

    public JPanel getGameOverPanel(){
        return gameOverPanel;
    }
}
