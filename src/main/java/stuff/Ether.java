package stuff;


import entity.Character;

public class Ether extends Item {

    public Ether() {
        super("Ether", "PATH");
    }

    public void heal(Character character){
        character.setMp((int) (character.getMp() * 0.5));
    }

    @Override
    public Item clone(){
        return new Ether();
    }
}
