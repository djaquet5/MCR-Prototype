package Stuff;

public class Potion extends Item {

    public Potion(){
        super("Potion", "PATH");
    }

    public void initialize() {

    }

    @Override
    public Item clone(){
        return new Potion();
    }
}
