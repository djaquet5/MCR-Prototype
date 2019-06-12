package display;

import controller.MapController;
import maze.Cell;
import maze.Dungeon;
import prototypal.Prototype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Singleton Map displayer of the game
 */
public class GameDisplayer extends JPanel implements ActionListener {

    private static GameDisplayer instance;

    private Timer timer;

    private final static int MAZE_SIZE = 1000;

    private int cellSize;
    private int imageSize;
    private int cellOffset;

    private Image HERO;

    private Dungeon dungeon;

    private GameDisplayer() {
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

        MapController.getHero().setPosition(dungeon.getStartCell());
        MapController.discoverCells();
    }

    private void loadImages() {
        HERO = new ImageIcon(MapController.getHero().getDisplayImage()).getImage();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2d = (Graphics2D) graphics;

        drawDungeon(g2d);

        g2d.drawImage(HERO, cellOffset + MapController.getHero().getPosition().getPosX() * cellSize,
                cellOffset + MapController.getHero().getPosition().getPosY() * cellSize, imageSize, imageSize,  this);

    }

    /**
     * First draw the dungeon, then monsters, and finally the times
     * @param g2d
     */
    private void drawDungeon(Graphics2D g2d) {
        for(int i = 0; i < dungeon.getDimension(); i++) {
            g2d.drawLine(0, i * cellSize, getWidth(), i * cellSize);
            g2d.drawLine(i* cellSize, 0, i*cellSize, getHeight());
        }

        for(int i = 0; i < dungeon.getDimension(); i++) {
            for(int j = 0; j < dungeon.getDimension(); j++) {
                Cell currentCell = dungeon.getCells()[i][j];
                currentCell.draw(g2d);
            }
        }
        for(Prototype p : MapController.getMonsters()){
            if(p.getPosition().getIsDiscovered()) {
                Image mOrS = new ImageIcon(p.getDisplayImage()).getImage();
                g2d.drawImage(mOrS, cellOffset + p.getPosition().getPosX() * cellSize,
                        cellOffset + cellOffset + p.getPosition().getPosY() * cellSize, imageSize, imageSize, this);
            }
        }

        for(Prototype p : MapController.getItems()){
            if(p.getPosition().getIsDiscovered()) {
                Image mOrS = new ImageIcon(p.getDisplayImage()).getImage();
                g2d.drawImage(mOrS, cellOffset + p.getPosition().getPosX() * cellSize,
                        cellOffset + cellOffset + p.getPosition().getPosY() * cellSize, imageSize, imageSize, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    public int getCellOffset() {
        return cellOffset;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getImageSize() {
        return imageSize;
    }

    public static GameDisplayer getInstance(){
        if(instance == null){
            instance = new GameDisplayer();
        }
        return instance;
    }
}
