package Person;

import Magic.Spell;

public abstract class Character {
    int hp;
    int maxHp;
    int mp;
    int maxMp;
    int attack;
    int defence;
    int magic;
    int magicDefence;
    String displayImage;

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
        if(hp < 0){
            //Meurt
        }
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

    public int attack(Character c){
        int damage = Math.max(this.attack + (int)(Math.random() * 13) - c.getDefence(), 1);
        c.setHp(damage * -1);
        return damage;
    }

    public int throwMagic(Character c, Spell s){
        if(this.mp < s.getMpCost()){
            throw new IllegalArgumentException("Vous n'avez pas assez de mp !");
        }
        int damage = Math.max((int)Math.floor(this.magic * s.getPower() / 100) +
                (int)(Math.random() * 13) - c.getMagicDefence(), 1);
        c.setHp(damage * -1);
        this.setMp(s.getMpCost() * -1);
        return damage;
    }
}
