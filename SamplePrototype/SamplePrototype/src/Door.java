public class Door extends MapSite {
   private Room left;
   private Room right;

   public Door() {}

   public Door(Room left, Room right) {
      init(left, right);
   }

   // Constructeur de copie
   public Door(Door d) {
      this(d.left, d.right);
   }

   public void init(Room left, Room right) {
      this.left = left;
      this.right = right;
   }

   @Override
   public Door clone() {
      return new Door(this);
   }
}
