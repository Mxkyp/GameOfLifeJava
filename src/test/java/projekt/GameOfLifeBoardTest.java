package projekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class GameOfLifeBoardTest {

  @Test
  void testInitGivenSize() {
    final int row = 5;
    final int col = 6;
    GameOfLifeBoard golb1 = new GameOfLifeBoard(row, col);
    GameOfLifeBoard golb2 = new GameOfLifeBoard(row, col);

    //then
    int same = row * col;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (golb1.getBoard()[i][j] == golb2.getBoard()[i][j]) {
          same--;
        }
      }
    }
    assertTrue(same > 0);
  }


  @Test
  void testInitWithoutSize() {
    GameOfLifeBoard golb1 = new GameOfLifeBoard();
    GameOfLifeBoard golb2 = new GameOfLifeBoard();
    final int row_number = golb1.getBoard().length;
    final int col_number = golb1.getBoard()[0].length;
    //then
    int same = row_number * col_number;

    for (int i = 0; i < row_number; i++) {
      for (int j = 0; j < col_number; j++) {
        if (golb1.getBoard()[i][j] == golb2.getBoard()[i][j]) {
          same--;
        }
      }
    }
    assertTrue(same > 0);
  }


  @Test
  void testGetBoard() {
    GameOfLifeBoard golb1 = new GameOfLifeBoard(5, 5);
    boolean[][] copyBoard = golb1.getBoard();
    copyBoard[0][0] = !copyBoard[0][0];
    
    assertNotEquals(copyBoard[0][0], golb1.getBoard()[0][0], "The change in "  
        + "copyBoard should not be a change in the orignal board");
  }


  @Test
  void testSetboard() {
    GameOfLifeBoard golb1 = new GameOfLifeBoard(3, 3);
    final boolean [][]toImport = { {false, false, false },
                                   {false,  true, false },
                                   {true, false,  true}}; 
    golb1.setBoard(toImport);
    toImport[0][0] = true;
    assertNotEquals(golb1.getBoard()[0][0], toImport[0][0], "The change in "  
        + "toImport should not be a change in the orignal board");
  }
  
  @Test 
  void testPrintBoard() {
    GameOfLifeBoard golb1 = new GameOfLifeBoard(3, 3);
    final boolean [][]toImport = { {false, false, false },
                                   {false,  true, false },
                                   {true, false,  true}}; 
    golb1.setBoard(toImport);
    OutputStream os = new ByteArrayOutputStream();
    PrintStream stream = new PrintStream(os);
    System.setOut(stream);

    golb1.printBoard();
    String actualOutput = os.toString();
    String expectedOutput = "0 0 0 \n0 1 0 \n1 0 1 \n";
    assertEquals(expectedOutput, actualOutput);
  }


  @Test 
  void testDoSimulationStep() {
    final boolean [][]before = { {false, true, false },
                                 {false,  true, false },
                                 {false, false, false},
                                 {true, false,  true}}; 
    final boolean [][]expectedAfter = { {false, true, false},
                                        {false, false, false},
                                        {true,  true,  true},
                                        {true,  true,  true}}; 
    GameOfLifeBoard golb1 = new GameOfLifeBoard(4, 3);

    golb1.setBoard(before);
    golb1.doSimulationStep();
    
    for (int i = 0; i < expectedAfter.length; i++) {
      for (int j = 0; j < expectedAfter[0].length; j++) {
        assertEquals(expectedAfter[i][j], golb1.getBoard()[i][j]);
      }
    }
  }
  
}
  
