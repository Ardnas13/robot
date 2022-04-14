package devoteamrobot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testInput(){
        String[] input1 = {"3", "4", "1", "2", "N", "RFLFF"};
        String[] input2 = {"90", "203", "0", "37", "E", "R"};
        String[] input3 = {"0", "4", "1", "2", "N", "RFLFF"};
        String[] input4 = {"3", "04", "1", "2", "N", "RFLFF"};
        String[] input5 = {"3", "4", "01", "2", "N", "RFLFF"};
        String[] input6 = {"3", "4", "1", "2", "NE", "RFLFF"};
        String[] input7 = {"3", "4", "1", "2", "N", "TEST"};
        assertTrue(InputCheck.isValidInput(input1));
        assertTrue(InputCheck.isValidInput(input2));
        assertFalse(InputCheck.isValidInput(input3));
        assertFalse(InputCheck.isValidInput(input4));
        assertFalse(InputCheck.isValidInput(input5));
        assertFalse(InputCheck.isValidInput(input6));
        assertFalse(InputCheck.isValidInput(input7));
    }

    @Test void testInGrid(){
        Room room = new Room(4,7);
        assertTrue(room.isInRoom(2,4));
        assertTrue(room.isInRoom(0,0));
        assertFalse(room.isInRoom(4,4));
        assertFalse(room.isInRoom(3,7));
        assertFalse(room.isInRoom(4,7));
    }

    @Test
    public void testCommand(){
        Room room = new Room(5,5);
        Robot testRobot1 = new Robot(1,2,"N",room);
        testRobot1.executeCommand("RFRFFRFRF");
        assertEquals(testRobot1.getPosandDir(), "1 3 N");
        Robot testRobot2 = new Robot(0,0,"E",room);
        testRobot2.executeCommand("RFLFFLRF");
        assertEquals(testRobot2.getPosandDir(), "3 1 E");
    }



}
