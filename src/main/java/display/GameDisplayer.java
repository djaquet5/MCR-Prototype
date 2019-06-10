package display;

import controller.MapController;
import entity.GameCharacter;
import entity.hero.Kagami;
import maze.Cell;
import maze.Dungeon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameDisplayer extends JPanel implements ActionListener {

    private Cell startCell;

    private static int turn = 0;

    private Timer timer;

    private final static int MAZE_SIZE = 1000;

    private int cellSize;
    private int imageSize;
    private int cellOffset;

    private Image STONE;
    private Image DIRT;
    private Image GRASS;

    private Image HERO;

    private Dungeon dungeon;

    public GameDisplayer() {
        init();
    }

    private void init() {
        loadImages();
        setBackground(Color.black);
        setPreferredSize(new Dimension(MAZE_SIZE, MAZE_SIZE));

        timer = new Timer(40, this);
        timer.start();
        setFocusable(true);

        dungeon = MapController.getDungeon();

        this.cellSize = MAZE_SIZE / dungeon.getDimension();
        // TODO: reconfigure these hardcoded values
        this.imageSize = cellSize - 10;
        this.cellOffset = 5;

        this.startCell = dungeon.getCell(0, 0);

        MapController.getHero().setPosition(startCell);
    }

    private void loadImages() {

        STONE = new ImageIcon("src/textures/stone.jpg").getImage();
        DIRT = new ImageIcon("src/textures/dirt.png").getImage();
        GRASS = new ImageIcon("src/textures/grass.jpg").getImage();

        HERO = new ImageIcon("src/Characters/DM1/right-stand.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2d = (Graphics2D) graphics;

        drawDungeon(g2d);

        g2d.drawImage(HERO, cellOffset + MapController.getHero().getPosition().getPosX() * cellSize,
                cellOffset + MapController.getHero().getPosition().getPosY() * cellSize, imageSize, imageSize,  this);

    }

    private void drawDungeon(Graphics2D g2d) {
        for(int i = 0; i < dungeon.getDimension(); i++) {
            g2d.drawLine(0, i * cellSize, getWidth(), i * cellSize);
            g2d.drawLine(i* cellSize, 0, i*cellSize, getHeight());
        }

        for(int i = 0; i < dungeon.getDimension(); i++) {
            for(int j = 0; j < dungeon.getDimension(); j++) {
                Cell currentCell = dungeon.getCells()[i][j];
                if(currentCell.isReachable()) {
                    //g2d.drawImage(STONE, 5 , 5 + (i * 100) , 90, 90,  this);
                    g2d.drawImage(STONE, cellOffset + currentCell.getPosX() * cellSize,
                            cellOffset + currentCell.getPosY() * cellSize, imageSize, imageSize, this);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    public void moveHeroDown(GameCharacter hero) {
        Cell cell = hero.getPosition();
        Cell nextCell = dungeon.getCell(cell.getPosX(), cell.getPosY() + 1);
        if(nextCell.isReachable()) {
            hero.setPosition(nextCell);
        }
    }
}
