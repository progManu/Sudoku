package sudoku.core;

import sudoku.utilities.Coordinates;

class Board extends BaseBoard {

    private static final int MAX_CELLS_TO_FILL = 20;
    private static final int MIN_CELLS_TO_FILL = 10;
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
        int numberOfCellsToFill = randomGenerator.nextInt(MIN_CELLS_TO_FILL, MAX_CELLS_TO_FILL + 1);
        for (int i = 0; i < numberOfCellsToFill; i++) {
            Coordinates pos = new Coordinates(randomGenerator.nextInt(BOARD_SIZE), randomGenerator.nextInt(BOARD_SIZE));
            genPossibleNumber(pos);
        }
    }

    private void genPossibleNumber(Coordinates coordinate) {
        Integer possibleValue = null;

        long prevTime = System.currentTimeMillis();

        boolean inTime = true;
        do {
            possibleValue = randomGenerator.nextInt(9);
            inTime = System.currentTimeMillis() - prevTime <= 1000;
        }while(!Rules.checkAddingNumber(this, coordinate, possibleValue) && inTime);

        if (inTime == true) {
            this.grid[coordinate.getX()][coordinate.getY()] = possibleValue;
        }
        else{
            this.grid[coordinate.getX()][coordinate.getY()] = null;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                if (this.grid[i][j] != null) {
                    result += " \u001B[31m" + this.grid[i][j] + "\u001B[0m";
                }else {
                    result += " " + "\u001B[47m" + "n\u001B[0m";
                }
            }
            result += "\n";
        }
        return result;
    }


}
