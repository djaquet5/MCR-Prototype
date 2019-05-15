package entity.Hero;

import entity.Character;

public abstract class Hero extends Character {
    private int lvl;
    private int exp;
    private final int lvlcap;
    private int expToLvl;
    private final double vitality;
    private final double mysticism;
    private final double strength;
    private final double constitution;
    private final double intelligence;
    private final double wisdom;

    public Hero(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage, int lvl, int exp, int lvlcap, double vitality, double mysticism, double strength, double constitution, double intelligence, double wisdom) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
        this.lvl = lvl;
        this.exp = exp;
        this.lvlcap = lvlcap;
        expToLvl = 100 * (int)Math.pow(2, lvl-1);
        this.vitality = vitality;
        this.mysticism = mysticism;
        this.strength = strength;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
    }

    private void levelUp() {
        exp -= expToLvl;
        lvl++;
        expToLvl = 100 * (int)Math.pow(2, lvl-1);
        setMaxHp((int) (getMaxMp() * vitality));
        setMaxMp((int) (getMaxMp() * mysticism));
        setAttack((int) (getAttack() * strength));
        setDefence((int) (getDefence() * constitution));
        setMagic((int) (getMagic() * intelligence));
        setMagicDefence((int) (getMagicDefence() * wisdom));

        setHp(getMaxHp());
        setMp(getMaxMp());
    }

    public void gainExp(int exp) {
        if (lvl != lvlcap) {
            this.exp += exp;
            if (this.exp >= expToLvl)
                levelUp();
        }
    }

    public int getLvl() {
        return lvl;
    }

    public int getLvlcap() {
        return lvlcap;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getVitality() {
        return vitality;
    }

    public double getMysticism() {
        return mysticism;
    }

    public double getStrength() {
        return strength;
    }

    public double getConstitution() {
        return constitution;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public double getWisdom() {
        return wisdom;
    }
}
