public class Maze extends MapSite {
   public Maze() {}

   // Constructeur de copie
   public Maze(Maze m) {}

   @Override
   public Maze clone() {
      return new Maze(this);
   }
}
