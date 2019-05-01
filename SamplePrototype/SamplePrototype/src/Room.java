public class Room extends MapSite {
   private int size;

   public Room() {}

   public Room(int size) {
      init(size);
   }

   public Room(Room r) {
      this(r.size);
   }

   public void init(int size){
      this.size = size;
   }

   @Override
   public Room clone() {
      return new Room(this);
   }
}
