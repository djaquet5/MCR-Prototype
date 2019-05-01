public class Wall extends MapSite {

   public Wall(){}

   // Constructeur de copie
   public Wall(Wall w) {

   }

   @Override
   public Wall clone() {
      return new Wall(this);
   }
}
