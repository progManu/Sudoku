package sudoku.core;

import sudoku.utilities.Coordinates;

public class Rules {

    public static boolean checkAddingNumber(BaseBoard board, Coordinates coordinate, int value) throws IllegalArgumentException {
        if (coordinate == null || value < 0) throw new IllegalArgumentException("Not valid parameters");

        if (board.getGrid()[coordinate.getX()][coordinate.getY()] != null) return false;

        boolean checkRow = checkRow(board, coordinate, value);
        boolean checkColumn = checkColumn(board, coordinate, value);
        boolean checkQuadrant = checkQuadrant(board, coordinate, value);

        return checkRow && checkColumn && checkQuadrant;
    }

    public static boolean checkRow(BaseBoard board, Coordinates coordinate, int value){
        //Check row
        for(int i = 0; i < Board.BOARD_SIZE; i++){
            Coordinates inspectedCoord = new Coordinates(coordinate.getX(), i);
            Integer inspectedValue = board.getGrid()[inspectedCoord.getX()][inspectedCoord.getY()];
            if (!coordinate.equals(inspectedCoord) && inspectedValue.equals(value)) return false;
        }

        return true;
    }

    public static boolean checkColumn(BaseBoard board, Coordinates coordinate, int value) {
        for(int i = 0; i < Board.BOARD_SIZE; i++){
            Coordinates inspectedCoord = new Coordinates(i, coordinate.getY());
            Integer inspectedValue = board.getGrid()[inspectedCoord.getX()][inspectedCoord.getY()];
            if (!coordinate.equals(inspectedCoord) && inspectedValue.equals(value)) return false;
        }
        return true;
    }

    public static boolean checkQuadrant(BaseBoard board, Coordinates coordinate, int value){
        Coordinates quadrantCoord = new Coordinates(coordinate.getX() / 3, coordinate.getY() / 3);

        // Check quadrant
        for(int i = 0; i < Board.BOARD_SIZE / 3; i++){
            for(int j = 0; j < Board.BOARD_SIZE / 3; j++){
                Coordinates inspectedCoord = new Coordinates(quadrantCoord.getX() +  i, quadrantCoord.getY() + j);
                Integer inspectedValue = board.getGrid()[inspectedCoord.getX()][inspectedCoord.getY()];
                if (!coordinate.equals(inspectedCoord) && inspectedValue.equals(value)) return false;
            }
        }

        return true;
    }

}
