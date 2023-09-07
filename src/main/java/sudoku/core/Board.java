package sudoku.core;

import sudoku.render.Display;
import sudoku.utilities.Cooridinates;

import java.util.Random;

public class Board implements Display {

    protected static final int BOARD_SIZE = 9;
    private static final int MAX_CELLS_TO_FILL = 50;
    private int[][] grid;
    private static final Random rand = new Random();

    private static Board instance = null;

    // Costruttore invisibile
    private Board(int[][] grid) {
        this.grid = grid;
    }

    public static Board getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new Board(newBoard());
        }
        return instance;
    }

    protected static int[][] newBoard() {
        int[][] grid = new int[BOARD_SIZE][BOARD_SIZE];

        int numberOfCellsToFill = rand.nextInt(MAX_CELLS_TO_FILL + 1);
        for (int i = 0; i < numberOfCellsToFill; i++) {
            Cooridinates pos = new Cooridinates(rand.nextInt(BOARD_SIZE), rand.nextInt(BOARD_SIZE));
            grid[pos.getX()][pos.getY()] = genPossibleNumber(instance);
        }

        return grid;
    }

    // TODO: add rules to insert correct numbers
    private static int genPossibleNumber(Board b){
        return rand.nextInt(9);
    }

    public int getBoardCell(Cooridinates c){
        return this.grid[c.getX()][c.getY()];
    }

    @Override
    public boolean drawTerminal() {
        Cooridinates tempCoord = new Cooridinates(0, 0);

        for(int i = 0; i <  BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                tempCoord.setX(i);
                tempCoord.setY(j);
                System.out.print(" " + this.getBoardCell(tempCoord) + " ");
            }
            System.out.println();
        }
        return true;
    }

    @Override
    public boolean drawUI() {
        return false;
    }

}
