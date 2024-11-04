package projekt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**. check abstract class and its subclasses
 * 
 */
public class GameOfLifeDimensionTest {
  @Test
  public void testGameOfLifeRow() {
    final boolean [][]given = { {false, true, false },
                                {false,  true, false },
                                {false, false, false},
                                {true, false,  true}}; 

    GameOfLifeBoard golb1 = new GameOfLifeBoard(4, 3);
    golb1.setBoard(given);
    
    GameOfLifeCell[][] board = new GameOfLifeCell[4][3];
   
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = new GameOfLifeCell();
        board[i][j].updateState(golb1.getBoard()[i][j].getCellState());
      }
    }

    GameOfLifeDimension row0 = new GameOfLifeRow(board, 0);
    assertEquals(1, row0.countAliveCells());
    assertEquals(2, row0.countDeadCells());

    GameOfLifeDimension row1 = new GameOfLifeRow(board, 1);
    assertEquals(1, row1.countAliveCells());
    assertEquals(2, row1.countDeadCells());

    GameOfLifeDimension row3 = new GameOfLifeRow(board, 3);
    assertEquals(2, row3.countAliveCells());
    assertEquals(1, row3.countDeadCells());
  }

  @Test
  public void testGameOfLifeColumn() {
    final boolean [][]given = { {false, true, false },
                                {false,  true, false },
                                {false, false, false},
                                {true, false,  true}}; 

    GameOfLifeBoard golb1 = new GameOfLifeBoard(4, 3);
    golb1.setBoard(given);
    
    GameOfLifeCell[][] board = new GameOfLifeCell[4][3];
   
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = new GameOfLifeCell();
        board[i][j].updateState(golb1.getBoard()[i][j].getCellState());
      }
    }

    GameOfLifeDimension col0 = new GameOfLifeColumn(board, 0);
    assertEquals(1, col0.countAliveCells());
    assertEquals(3, col0.countDeadCells());

    GameOfLifeDimension col1 = new GameOfLifeColumn(board, 1);
    assertEquals(2, col1.countAliveCells());
    assertEquals(2, col1.countDeadCells());

    GameOfLifeDimension col2 = new GameOfLifeColumn(board, 2);
    assertEquals(1, col2.countAliveCells());
    assertEquals(3, col2.countDeadCells());
  }
}
