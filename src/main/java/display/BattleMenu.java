package display;

import controller.BattleController;
import controller.MapController;
import entity.hero.Hero;
import entity.monster.Monster;
import magic.Spell;
import stuff.Item;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class BattleMenu extends Thread {
    private JPanel battlePanel;
    private JComboBox<Item> comboBoxObject;
    private JComboBox<Spell> comboBoxMagic;
    private JLabel hpHeroLabel;
    private JLabel mpHeroLabel;
    private JLabel hpMonsterLabel;
    private JLabel mpMonsterLabel;
    private JLabel pictureLabel;
    private JButton attackButton;
    private JButton magicButton;
    private JButton useButton;
    private JLabel infoLabel;
    private Monster monster;
    private Hero hero;

    private String info;

    private Spell selectedSpell;
    private Item selectedItem;

    public BattleMenu(Monster monster, Hero hero){
        this.monster = monster;
        this.hero = hero;

        ImageIcon icon = new ImageIcon(monster.getDisplayImagePath());
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        pictureLabel.setIcon(icon);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        hpHeroLabel.setForeground(Color.GREEN);
        mpHeroLabel.setForeground(Color.BLUE);
        hpMonsterLabel.setForeground(Color.GREEN);
        mpMonsterLabel.setForeground(Color.BLUE);

        hpHeroLabel.setBorder(border);
        mpHeroLabel.setBorder(border);
        hpMonsterLabel.setBorder(border);
        mpMonsterLabel.setBorder(border);

        attackButton.setText("Attack");
        attackButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                info = BattleController.attack(hero, monster) + "\n";
                movement();
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

        if(!hero.getSpellSlots().isEmpty()) {
            // First spell selected by default
            selectedSpell = hero.getSpellSlots().get(0);
            for(Spell spell : hero.getSpellSlots()){
                comboBoxMagic.addItem(spell);
            }
            comboBoxMagic.addActionListener(actionEvent -> {
                selectedSpell = (Spell) comboBoxMagic.getSelectedItem();
            });
        }

        if(!hero.getInventory().isEmpty()) {
            // First item selected by default
            selectedItem = hero.getInventory().get(0);
            for(Item item : hero.getInventory()){
                comboBoxObject.addItem(item);
            }
            comboBoxObject.addActionListener(actionEvent -> {
                selectedItem = (Item)comboBoxObject.getSelectedItem();
            });
        }

        magicButton.setText("Cast magic");
        magicButton.addActionListener(actionEvent -> {
            if(selectedSpell != null) {
                info = BattleController.castSpell(hero, selectedSpell, monster) + "\n";
                movement();
            }
        });

        useButton.setText("Use item");
        useButton.addActionListener(actionEvent -> {
            if(selectedItem != null) {
                info = BattleController.useItem(hero, selectedItem)+ "\n";
                comboBoxObject.removeAllItems();
                for(Item item : hero.getInventory()){
                    comboBoxObject.addItem(item);
                }
                movement();
            }
        });

        info = "A wild " + monster + " appears ! ";
        updateInfo();
    }

    private void updateInfo(){
        hpHeroLabel.setText("HP : " + hero.getHp() + " / " + hero.getMaxHp());
        mpHeroLabel.setText("MP : " + hero.getMp() + " / " + hero.getMaxMp());
        hpMonsterLabel.setText("HP : " + monster.getHp() + " / " + monster.getMaxHp());
        mpMonsterLabel.setText("MP : " + monster.getMp() + " / " + monster.getMaxMp());
        infoLabel.setText(info);
        System.out.println(info);
    }

    private void movement(){
        info += monster.randomMove(hero);
        updateInfo();
        if(monster.isDead() || hero.isDead()){
            MapController.enableGame();
            MapController.signal(monster);
        }
    }

    public JPanel getBattlePanel(){
        return battlePanel;
    }
}
