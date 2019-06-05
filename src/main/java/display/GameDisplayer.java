package display;

import maze.Dungeon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDisplayer extends JPanel implements ActionListener {

    private Dungeon dungeon;

    private final static int MAZE_DIMENSION = 10;
    private final static int MAZE_SIZE = 1000;

    public final static Image STONE = new ImageIcon("src/textures/stone.jpg").getImage();
    public final static Image DIRT = new ImageIcon("src/textures/dirt.png").getImage();


    public GameDisplayer() {
        loadImages();
        setBackground(Color.black);
        setPreferredSize(new Dimension(MAZE_SIZE, MAZE_SIZE));
        //Dungeon dungeon = new Dungeon(MAZE_DIMENSION, MAZE_DIMENSION);
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/textures/grass.jpg");

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2d = (Graphics2D) graphics;

        g2d.setColor(Color.WHITE);

        for(int i = 0; i < MAZE_DIMENSION; i++) {
            g2d.drawLine(0, i * 100, getWidth(), i * 100);
            g2d.drawLine(i* 100, 0, i*100, getHeight());
        }

        //g2d.drawImage(grass, 5, 5, 90, 90,  this);
        /*for(int i = 0; i < MAZE_DIMENSION; i++) {
            g2d.drawImage(grass, 5 , 5 + (i * 100) , 90, 90,  this);
            g2d.drawImage(stone, 5 + (i * 100), 5 + (i * 100) , 90, 90,  this);
        }*/

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public void generateRandomDungeon() {
        
    }
}
