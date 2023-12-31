package sudoku.core;

import sudoku.utilities.Coordinates;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    private final static Scanner scanner = new Scanner(System.in);

    protected static Coordinates getCoordinatesInput() throws IllegalArgumentException {
        System.out.println("Insert x, y coordinates: ");
        String input = scanner.nextLine();
        String[] stringCoordinates = input
                .replaceAll("\\s", "")
                .split(",");

        return checkAndReturnCoord(stringCoordinates);
    }

    protected static int getValueInput() throws IllegalArgumentException {
        System.out.println("Insert number value: ");
        int input = scanner.nextInt();
        scanner.nextLine(); // This is done because there is a return character that is not captured by the scanner

        if(input > 9 || input < 1) throw new IllegalArgumentException("Coordinates out of bounds");

        return input;
    }

    public static Coordinates checkAndReturnCoord(String[] numberStringsArray) throws IllegalArgumentException{

        if (numberStringsArray.length != 2) throw new IllegalArgumentException("Wrong Number of Parameters");

        Coordinates coordinate = new Coordinates(Integer.parseInt(numberStringsArray[0]),
                Integer.parseInt(numberStringsArray[1]));

        if ((coordinate.getX() >= Board.BOARD_SIZE || coordinate.getX() < 0) ||
                (coordinate.getY() >= Board.BOARD_SIZE || coordinate.getY() < 0))
        {
            throw new IllegalArgumentException("Coordinates out of bounds");
        }

        coordinate.setX(coordinate.getX());
        coordinate.setY(coordinate.getY());

        return coordinate;
    }
}
