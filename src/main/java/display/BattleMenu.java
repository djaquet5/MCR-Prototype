package display;

import controller.BattleController;
import controller.MapController;
import entity.hero.Hero;
import entity.monster.Monster;
import magic.Spell;
import stuff.Item;

import javax.swing.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Objects;

public class BattleMenu extends Thread {
    private JPanel battlePanel;
    private JComboBox<Map.Entry<Item, Integer>> comboBoxObject;
    private JComboBox<Spell> comboBoxMagic;
    private JLabel hpHeroLabel;
    private JLabel mpHeroLabel;
    private JLabel hpMonsterLabel;
    private JLabel mpMonsterLabel;
    private JLabel attackLabel;
    private JLabel magicLabel;
    private JLabel useLabel;
    private JLabel pictureLabel;
    private JLabel infoLabel;
    private Monster monster;
    private Hero hero;

    private String info;

    public BattleMenu(Monster monster, Hero hero){
        this.monster = monster;
        this.hero = hero;

        ImageIcon icon = new ImageIcon(monster.getDisplayImage());
        pictureLabel.setDisabledIcon(icon);

        attackLabel.setText("Attack");
        attackLabel.addMouseListener(new MouseListener() {

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

        magicLabel.setText("Cast magic");
        useLabel.setText("Use item");

        for(Spell spell : hero.getSpellSlots()){
            comboBoxMagic.addItem(spell);
        }
        comboBoxMagic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                info = BattleController.castSpell(hero, (Spell) comboBoxMagic.getSelectedItem(), monster) + "\n";
                movement();
            }
        });

        for(Map.Entry<Item, Integer> item : hero.getInventory().entrySet()){
            comboBoxObject.addItem(item);
        }
        comboBoxObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                info = BattleController.useItem(hero, ((Map.Entry<Item, Integer>) Objects.requireNonNull(comboBoxObject.getSelectedItem())).getKey()) + "\n";
                movement();
            }
        });
        info = "A wild " + monster + " appear!";
        updateInfo();
    }

    private void updateInfo(){
        hpHeroLabel.setText("" + hero.getHp() + "/" + hero.getMaxHp());
        mpHeroLabel.setText("" + hero.getMp() + "/" + hero.getMaxMp());
        hpMonsterLabel.setText("" + monster.getHp() + "/" + monster.getMaxHp());
        mpMonsterLabel.setText("" + monster.getMp() + "/" + monster.getMaxMp());
        infoLabel.setText(info);
        System.out.println(info);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void movement(){
        info += monster.randomMove(hero);
        updateInfo();
        if(monster.isDead() || hero.isDead()){
            SwingUtilities.getWindowAncestor(battlePanel).dispose();
        }
    }

    public JPanel getBattlePanel(){
        return battlePanel;
    }
}
