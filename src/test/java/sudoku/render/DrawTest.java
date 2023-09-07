package sudoku.render;

import org.junit.jupiter.api.Test;
import sudoku.core.Board;

public class DrawTest {
    @Test
    public void draw(){
        Board b = Board.getInstance();
        assert(b.drawTerminal());
    }

    @Test
    public void prova(){
        assert(false);
    }
}
