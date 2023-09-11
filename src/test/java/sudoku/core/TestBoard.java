package sudoku.core;

import sudoku.utilities.Coordinates;

public class TestBoard extends BaseBoard {

    private static final int MAX_CELLS_TO_FILL = 20;
    private static Board instance;

    protected TestBoard() {
        this.createNewGrid();
    }

    private void genPossibleNumber(Integer[][] grid, Coordinates coordinate) {
        grid[coordinate.getX()][coordinate.getY()] = randomGenerator.nextInt(9);
    }

    @Override
    protected void createNewGrid() {
        int value = 1;
        for(int i = 0; i < BOARD_SIZE; i += 3){
            for(int j = 0; j < Board.BOARD_SIZE; j += 3){
                Coordinates inspectedCoord = new Coordinates(i, j);
                this.grid[inspectedCoord.getX()][inspectedCoord.getY()] = value;
                value++;
            }
        }
    }
}
