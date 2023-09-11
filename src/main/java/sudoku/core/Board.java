package sudoku.core;

import sudoku.utilities.Coordinates;

class Board extends BaseBoard {

    private static final int MAX_CELLS_TO_FILL = 20;
    private static Board instance;

    private Board() {
        this.createNewGrid();
    }

    public static Board getInstance() {
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    @Override
    protected void createNewGrid() {
        int numberOfCellsToFill = randomGenerator.nextInt(MAX_CELLS_TO_FILL + 1);
        for (int i = 0; i < numberOfCellsToFill; i++) {
            Coordinates pos = new Coordinates(randomGenerator.nextInt(BOARD_SIZE), randomGenerator.nextInt(BOARD_SIZE));
            genPossibleNumber(this.grid, pos);
        }
    }

    private void genPossibleNumber(Integer[][] grid, Coordinates coordinate) {
        grid[coordinate.getX()][coordinate.getY()] = randomGenerator.nextInt(9);
    }


}
