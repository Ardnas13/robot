package devoteamrobot;

public class Room {
    private int wide;
    private int deep;

    public Room(int wide, int deep){
        this.wide = wide;
        this.deep = deep;
    }
   /**
   * Checks if the coordinates are inside the room.
   * @return true if both the coordinates are smaller than this Room's size otherwise false.
   */
    public boolean isInRoom(int w, int d){
        return (w < this.wide && d < this.deep);
    }

}
