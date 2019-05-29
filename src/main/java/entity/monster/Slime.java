package entity.monster;

public class Slime extends Monster{
    public Slime(){
        super(60, 20, 40, 180, 20, 10, "PATH", 10);
    }

    public void dedouble(){

    }

    @Override
    public Monster clone(){
        return new Slime();
    }
}
