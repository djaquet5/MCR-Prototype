import controller.MapController;
import entity.hero.*;
import maze.Dungeon;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu {
    private JTextArea selectYourCharacterTextArea;
    private JButton magusButton;
    private JButton warriorButton;
    private JButton kagamiButton;

    public MainMenu(){
        magusButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                //new MapController(new Magus(), new Dungeon(50, 50));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });

        warriorButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                //new MapController(new Warrior(), new Dungeon(50, 50));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });

        kagamiButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                //new MapController(new Kagami(), new Dungeon(50, 50));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}

            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
    }
}
