package sudoku.core;

import sudoku.utilities.Coordinates;

import java.util.Random;

public abstract class BaseBoard {
    final static int BOARD_SIZE = 9;
    protected Integer[][] grid = new Integer[BOARD_SIZE][BOARD_SIZE];
    Random randomGenerator = new Random();

    protected abstract void createNewGrid();

    public Integer[][] getGrid(){
        return this.grid;
    }

    protected void setGridValue(Coordinates coordinates, int value){
        this.grid[coordinates.getX()][coordinates.getY()] = value;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                if (this.grid[i][j] != null) {
                    result += " " + this.grid[i][j];
                }else {
                    result += " n";
                }
            }
            result += "\n";
        }
        return result;
    }
}
