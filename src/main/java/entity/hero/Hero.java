package entity.hero;

import entity.GameCharacter;

public abstract class Hero extends GameCharacter {
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

    public Hero(int hp, int mp, int attack, int defence, int magic, int magicDefence, String displayImage, double vitality, double mysticism, double strength, double constitution, double intelligence, double wisdom) {
        super(hp, mp, attack, defence, magic, magicDefence, displayImage);
        this.lvl = 1;
        this.exp = 0;
        this.lvlcap = 100;
        expToLvl = 100 * (int)Math.pow(2, lvl-1);
        this.vitality = vitality;
        this.mysticism = mysticism;
        this.strength = strength;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
    }

    private void levelUp() {
        exp = 0;
        lvl++;
        expToLvl = 100 * (int)Math.pow(2, lvl-1);
        setMaxHp(getMaxHp() + (int) (getMaxHp() * vitality));
        setMaxMp(getMaxMp() + (int) (getMaxMp() * mysticism));
        setAttack(getAttack() + (int) (getAttack() * strength));
        setDefence(getDefence() + (int) (getDefence() * constitution));
        setMagic(getMagic() + (int) (getMagic() * intelligence));
        setMagicDefence(getMagicDefence() + (int) (getMagicDefence() * wisdom));

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

    public abstract String getDisplayImageDown();

    public abstract String getDisplayImageUp();

    public abstract String getDisplayImageRight();

    public abstract String getDisplayImageLeft();
}
