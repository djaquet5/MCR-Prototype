package Magic;

public class Spell {
    String name;
    int power;
    int mpCost;

    public Spell(String name, int power, int mpCost){
        this.name = name;
        this.power = power;
        this.mpCost = mpCost;
    }

    public String getName(){
        return name;
    }

    public int getPower(){
        return power;
    }

    public int getMpCost(){
        return mpCost;
    }
}
