package display;

import controller.MapController;
import entity.hero.*;
import maze.Dungeon;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Main menu
 */
public class MainMenu {
    private JTextArea selectYourCharacterTextArea;
    private JButton magusButton;
    private JButton warriorButton;
    private JButton kagamiButton;
    private JPanel mainPanel;

    public MainMenu(){
        magusButton.addMouseListener(getCustomMouseListener(new Magus()));
        warriorButton.addMouseListener(getCustomMouseListener(new Warrior()));
        kagamiButton.addMouseListener(getCustomMouseListener(new Kagami()));
    }

    JPanel getMainPanel(){
        return mainPanel;
    }

    private MouseListener getCustomMouseListener(Hero hero) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                new MapController(hero);
                MapController.generate10x10Dungeon();
                Game.getInstance().changePanel(GameDisplayer.getInstance());
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        };
    }
}
