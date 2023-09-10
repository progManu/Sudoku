package sudoku.core;

import sudoku.utilities.Coordinates;

public class Sudoku {
    private final Board board = Board.getInstance();
    GameStates state = GameStates.INPUT;
    private boolean gameEnd = false;

    private static Sudoku instance = null;

    private Sudoku(){

    }

    public static Sudoku getInstance() {
        if(instance == null)
            return new Sudoku();
        return instance;
    }

    public void run(){

        Coordinates cell = null;
        int cellValue = -1;

        while(!gameEnd) {
            switch (this.state) {
                case INPUT:
                    this.state = GameStates.UPDATE;
                    try{
                        cellValue = Input.getValueInput();
                        cell = Input.getCoordinatesInput();
                    }catch (IllegalArgumentException e){
                        e.printStackTrace();
                        this.state = GameStates.INPUT;
                    }
                    break;
                case UPDATE:
                    board.setCellValue(cell, cellValue);
                    this.state = GameStates.OUTPUT;
                    break;
                case OUTPUT:
                    board.drawTerminal();
                    this.state = GameStates.INPUT;
                    break;
            }
        }
    }
}
