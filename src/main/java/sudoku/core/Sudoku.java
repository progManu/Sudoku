package sudoku.core;

import sudoku.utilities.Coordinates;

public class Sudoku {
    private final Board board = Board.getInstance();
    GameStates state = GameStates.OUTPUT;
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

        while(!Rules.isGameEnded(this.board)) {
            switch (this.state) {
                case INPUT:
                    this.state = GameStates.UPDATE;
                    try {
                        cellValue = Input.getValueInput();
                        cell = Input.getCoordinatesInput();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        this.state = GameStates.INPUT;
                    }
                    break;
                case UPDATE:
                    this.state = GameStates.OUTPUT;

                    try{
                        boolean checkRes = Rules.checkAddingNumber(board, cell, cellValue);
                        if (checkRes) {board.setGridValue(cell, cellValue);}
                        else {this.state = GameStates.INPUT;}
                    }catch (IllegalArgumentException e){
                        e.printStackTrace();
                        this.state = GameStates.INPUT;
                    }

                    break;
                case OUTPUT:
                    System.out.println(board.toString());
                    this.state = GameStates.INPUT;
                    break;
            }
        }
    }
}
