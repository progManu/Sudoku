package sudoku.core;

import sudoku.utilities.Coordinates;

import java.util.Scanner;

public class Input {
    private final static Scanner scanner = new Scanner(System.in);

    protected static Coordinates getInput() throws IllegalArgumentException {
        System.out.println("Insert x, y coordinates: ");
        String input = scanner.nextLine();
        String[] stringCoordinates = input.split("\\.");

        return checkAndReturnCoord(stringCoordinates);
    }

    public static Coordinates checkAndReturnCoord(String[] numberStringsArray) throws IllegalArgumentException{
        if (numberStringsArray.length != 2) throw new IllegalArgumentException("Wrong Number of Parameters");

        Coordinates coordinate = new Coordinates(Integer.parseInt(numberStringsArray[0]),
                Integer.parseInt(numberStringsArray[1]));

        if ((coordinate.getX() > Board.BOARD_SIZE || coordinate.getX() < 0) ||
                (coordinate.getY() > Board.BOARD_SIZE || coordinate.getY() < 0))
        {
            throw new IllegalArgumentException("Coordinates out of bounds");
        }

        return coordinate;
    }
}
