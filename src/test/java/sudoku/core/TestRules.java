package sudoku.core;

import org.junit.jupiter.api.Test;
import sudoku.utilities.Coordinates;

public class TestRules {

    @Test
    public void testVerticalInsertion(){
        TestBoard testBoard = new TestBoard();
        boolean result = Rules.checkRow(testBoard, new Coordinates(0, 1), 1);
        assert(!result);
    }

    @Test
    public void testHorizontalInsertion(){
        TestBoard testBoard = new TestBoard();
        boolean result = Rules.checkColumn(testBoard, new Coordinates(1, 0), 1);
        assert(!result);
    }

    @Test
    public void testQuadrantInsertion(){
        TestBoard testBoard = new TestBoard();
        boolean result = Rules.checkQuadrant(testBoard, new Coordinates(1, 1), 1);
        assert(!result);
    }

    @Test
    public void testEndGame(){
        Integer[][] fullGrid =  {
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        TestBoard testBoard = new TestBoard(fullGrid);

        boolean result = Rules.isGameEnded(testBoard);
        assert(result);
    }
}
