public class MazePrototypeFactory extends MazeFactory {
   private Maze prototypeMaze;
   private Room prototypeRoom;
   private Wall prototypeWall;
   private Door prototypeDoor;

   public MazePrototypeFactory(Maze m, Wall w, Room r, Door d){
      prototypeMaze = m;
      prototypeRoom = r;
      prototypeWall = w;
      prototypeDoor = d;
   }

   Maze createMaze () {
      Maze m = prototypeMaze.clone();

      // On crée les éléments qu'on veut à m

      return m;
   }

   Room makeRoom () {
      Room r = prototypeRoom.clone();

      return prototypeRoom.clone();
   }

   Wall makeWall () {
      return prototypeWall.clone();
   }

   Door makeDoor (Room left, Room right) {
      Door d = prototypeDoor.clone();
      d.init(left, right);

      return d;
   }
}
