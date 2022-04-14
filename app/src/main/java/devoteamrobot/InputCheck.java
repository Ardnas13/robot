package devoteamrobot;

public class InputCheck {
    
    private static boolean isValidGridSize(String input){
        return input.matches("^[1-9][0-9]*");
    }

    private static boolean isValidStartPos(String input){
        return input.matches("^[1-9][0-9]*|[0]");
    }

    private static boolean isDirection(String input){
        return input.matches("[NESW]");
    }

    private static boolean isCommand(String input){
        return input.matches("^(?:([FRL])(?!.*\\*))+$");
    }

    /**
   * Checks if the input is in the correct way.
   * @param inputs the input arguments, should include size of the room, 
   * robot's starting position and direction and commands,
   * must have a length of six. 
   * @return true if the input is in the correct form otherwise false.
   */
    public static boolean isValidInput(String[] inputs){
        if (!isValidGridSize(inputs[0])){
            return false;
        }
        if (!isValidGridSize(inputs[1])){
            return false;
        }
        if (!isValidStartPos(inputs[2])){
            return false;
        }
        if (!isValidStartPos(inputs[3])){
            return false;
        }
        if (!isDirection(inputs[4])){
            return false;
        }
        if (!isCommand(inputs[5])){
            return false;
        }
        return true;
    }
}
