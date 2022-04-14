package devoteamrobot;

public class App {

       /**
   * Creates a room and a robot and execute the commands on the robot, 
   * printing out the resulting position and direction of the robot.
   * @param args the input arguments, should include size of the room, 
   * robot's starting position and direction and commands,
   * must have a length of six.
   */
    public static void main(String[] args) {
        if (args.length != 6){
            System.out.println("Wrong number of inputs");
            System.exit(0);
        }
        
        if (InputCheck.isValidInput(args)){
            Room room = new Room(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            int robotStartWide = Integer.parseInt(args[2]);
            int robotStartDeep = Integer.parseInt(args[3]);
            if (!room.isInRoom(robotStartWide, robotStartDeep)){
                System.out.println("The robot's starting position is outside the room");
                System.exit(0);
            }
            String direction = args[4];
            String command = args[5];
            Robot robot = new Robot(robotStartWide, robotStartDeep, direction, room);
            robot.executeCommand(command);
            String newPosition = robot.getPosandDir();
            System.out.println(String.format("%s %s", "Report:", newPosition));
        } else {
            System.out.print("One or more inputs are wrong");
            System.exit(0);
        }

    }
}
    
