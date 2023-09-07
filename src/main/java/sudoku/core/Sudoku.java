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
        Coordinates c = null;
        while(!gameEnd) {
            switch (this.state) {
                case INPUT:
                    try{
                        c = Input.getInput();
                    }catch (IllegalArgumentException e){
                        e.printStackTrace();
                    }
                    this.state = GameStates.UPDATE;
                    break;
                case UPDATE:
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
