package devoteamrobot;

public class Robot {
    private int wide;
    private int deep;
    private int direction;
    private Room room;

    public Robot(int wide, int deep, String direction, Room room){
        this.wide = wide;
        this.deep = deep;
        this.direction = dirStringtoInt(direction);
        this.room = room;
    }

    private int dirStringtoInt(String direction){
        int intDirection;
        switch(direction){
            case "N": intDirection = 0; break;
            case "E": intDirection = 1; break;
            case "S": intDirection = 2; break;
            case "W": intDirection = 3; break;
            default: intDirection = -1; break;
        }
        return intDirection;
    }

    private String dirInttoString(int direction){
        String stringDirection;
        switch(direction){
            case 0: stringDirection = "N"; break;
            case 1: stringDirection = "E"; break;
            case 2: stringDirection = "S"; break;
            case 3: stringDirection = "W"; break;
            default: stringDirection = "Error"; break;
        }
        return stringDirection;
    }

    private void walkForward(){
        int newWide = wide;
        int newDeep = deep;
        switch(direction){
            case 0: newDeep -= 1; break;
            case 1: newWide += 1; break;
            case 2: newDeep += 1; break;
            case 3: newWide -= 1; break;
        }
        if (room.isInRoom(newWide, newDeep)){
            wide = newWide;
            deep = newDeep;
        }else{
            System.out.println("The robot is facing the wall and can't move forward");
        }
    }

    private void turnRight(){
        direction = (direction + 1) % 4;
    }

    private void turnLeft(){
        direction = (direction - 1) % 4;
    }

    /**
   * Gets the position and direction of this Robot.
   * @return this Robot's position and direction as String.
   */
    public String getPosandDir(){
        return String.format("%d %d %s", wide, deep, dirInttoString(direction));
    }

    /**
   * Changes the position and direction of the Robot according to the given command.
   * @param command The commands the robot should take.
   */
    public void executeCommand(String command){

        for (int i = 0; i < command.length(); i++) {
            switch(command.charAt(i)){
                case 'L': this.turnLeft(); break;
                case 'R': this.turnRight(); break;
                case 'F': this.walkForward(); break;
            }
        }
    }
}

