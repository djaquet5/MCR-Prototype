package Person;

import Magic.Spell;

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

    public Character(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage){
        this.hp = this.maxHp = hp;
        this.mp = this.maxMp = mp;
        this.attack = attack;
        this.defence = defence;
        this.magic = magic;
        this.magicDefence = magicDefence;
        this.displayImage = displayImage;
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

    public int attack(Character c){
        int damage = Math.max(this.attack + (int)(Math.random() * 13) - c.getDefence(), 1);
        c.setHp(damage * -1);
        return damage;
    }

    public int castMagic(Character target, Spell spell){
        if(this.mp < spell.getMpCost()){
            throw new IllegalArgumentException("Not enough Mana!");
        }
        int damage = Math.max((int)Math.floor(this.magic * spell.getPower() / 100) +
                (int)(Math.random() * 13) - target.getMagicDefence(), 1);
        target.setHp(damage * -1);
        this.setMp(spell.getMpCost() * -1);
        return damage;
    }
}
