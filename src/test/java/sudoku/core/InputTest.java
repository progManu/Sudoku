package sudoku.core;

import org.junit.jupiter.api.Test;
import sudoku.utilities.Coordinates;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class InputTest {
    @Test
    public void testInputNumbers(){
       Coordinates c1 = Input.checkAndReturnCoord(new String[]{"1", "3"});

       assert(c1.equals(new Coordinates(1, 3)));
    }

    @Test
    public void testInputOutOfBound(){
        try {
            Coordinates c1 = Input.checkAndReturnCoord(new String[]{"1", "10"});
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testInputNumbersFail() {
        try {
            Coordinates c1 = Input.checkAndReturnCoord(new String[]{"1", "3", "4"});
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testInputNotANumberFail() {
        try {
            Coordinates c1 = Input.checkAndReturnCoord(new String[]{"1", "x"});
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}
