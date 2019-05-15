package entity;

import magic.Spell;
import stuff.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Character {
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int attack;
    private int defence;
    private int magic;
    private int magicDefence;
    private String displayImage;
    private List<Spell> spellSlots;
    private Map<Item, Integer> inventory;

    public Character() {
        
    }

    public Character(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage){
        this.hp = this.maxHp = hp;
        this.mp = this.maxMp = mp;
        this.attack = attack;
        this.defence = defence;
        this.magic = magic;
        this.magicDefence = magicDefence;
        this.displayImage = displayImage;

        spellSlots = new ArrayList<Spell>();
        inventory = new HashMap<Item, Integer>();
    }

    public void setHp(int i){
        hp = Math.min(hp + i, maxHp);
    }

    public int getHp(){
        return hp;
    }

    public void setMp(int i){
        mp = Math.min(mp + i, maxMp);
    }

    public int getMp(){
        return mp;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefence(){
        return defence;
    }

    public int getMagic(){
        return magic;
    }

    public int getMagicDefence(){
        return magicDefence;
    }

    public String getDisplayImage(){
        return displayImage;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public List<Spell> getSpellSlots() {
        return spellSlots;
    }

    public void learnSpell(Spell spell) {
        if (spellSlots.contains(spell))
            System.out.println("Spell already known!");
        else
            spellSlots.add(spell);
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }

    private void addToinventory(Item item, int amount) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + amount);
        } else {
            inventory.put(item, amount);
        }
    }

    public int attack(Character c){
        int damage = Math.max(this.attack + (int)(Math.random() * 13) - c.getDefence(), 1);
        c.setHp(damage * -1);
        return damage;
    }

    public int castMagic(Character target, Spell spell){
        if(this.mp < spell.getMpCost()){
            System.out.println("Not enough Mana!");
            return 0;
        }
        int damage = Math.max((int)Math.floor(this.magic * spell.getPower() / 100) +
                (int)(Math.random() * 13) - target.getMagicDefence(), 1);
        target.setHp(damage * -1);
        this.setMp(spell.getMpCost() * -1);
        return damage;
    }
}
