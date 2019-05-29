package controler;

public class MapControler {
    private static int turn = 1;

    public static int getTurn(){
        return turn;
    }

    public void play(){
        while(true){
            /**
             * On bouge
             */
            ++turn;
        }
    }
}
