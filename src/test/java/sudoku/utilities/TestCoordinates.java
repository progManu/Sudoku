package sudoku.utilities;

import org.junit.jupiter.api.Test;

public class TestCoordinates {
    @Test
    public void testEqualCoordinates(){
        Coordinates c1 = new Coordinates(1, 3);
        Coordinates c2 = new Coordinates(1, 3);


        assert(c1.equals(c2) && !c1.equals(null) && !c2.equals(new Object()));
    }

    @Test
    public void testPrintStrings(){
        Coordinates c1 = new Coordinates(1, 3);
        String result = "{1, 3}";

        assert(result.equals(c1.toString()));
    }
}
