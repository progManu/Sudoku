package sudoku.utilities;

import org.junit.jupiter.api.Test;

public class TestCoordinates {
    @Test
    public void testEqualCoordinates(){
        Cooridinates c1 = new Cooridinates(1, 3);
        Cooridinates c2 = new Cooridinates(1, 3);


        assert(c1.equals(c2) && !c1.equals(null) && !c2.equals(new Object()));
    }
}
