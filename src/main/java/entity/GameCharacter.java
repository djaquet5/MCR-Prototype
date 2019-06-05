package entity;

import controller.MapController;
import magic.Spell;
import maze.ReachableCell;
import prototypal.Prototype;
import stuff.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameCharacter implements Prototype {
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int attack;
    private int defence;
    private int magic;
    private int magicDefence;
    private String displayImage;
    protected List<Spell> spellSlots;
    private Map<Item, Integer> inventory;
    private ReachableCell position;

    public GameCharacter() {

    }

    public GameCharacter(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage){
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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public void modifyHp(int i){
        hp = Math.min(hp + i, maxHp);
    }

    public int getHp(){
        return hp;
    }

    public void modifyMp(int i){
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setMagicDefence(int magicDefence) {
        this.magicDefence = magicDefence;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public List<Spell> getSpellSlots() {
        return spellSlots;
    }

    public ReachableCell getPosition(){ return position; }

    public void setPosition(ReachableCell position) {
        this.position = position;
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

    public void addToinventory(Item item, int amount) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + amount);
        } else {
            inventory.put(item, amount);
        }
    }

    public void useItem(Item item) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) - 1);
            item.use(this);
            if (inventory.get(item) == 0) {
                inventory.remove(item);
            }
        }
    }

    public int attack(GameCharacter c){
        int damage = Math.max(this.attack + (int)(Math.random() * 13) - c.getDefence(), 1);
        c.modifyHp(damage * -1);
        return damage;
    }

    public int castMagic(GameCharacter target, Spell spell){
        if(this.mp < spell.getMpCost()){
            System.out.println("Not enough Mana!");
            return -1;
        }

        int damage = Math.max((int)Math.floor(this.magic * spell.getPower() / 100) +
                    (int)(Math.random() * 13) - target.getMagicDefence(), 1);

        target.modifyHp(damage * -1);
        this.modifyMp(spell.getMpCost() * -1);

        return damage;
    }


    public void initialize(ReachableCell cell) {
        setPosition(cell);
        MapController.enterToGame(this);
    }
}
