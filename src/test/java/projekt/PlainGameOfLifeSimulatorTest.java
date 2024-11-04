package projekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import org.junit.jupiter.api.Test;

/**.
 * 
 */
public class PlainGameOfLifeSimulatorTest {

  @Test
  void testDoStep() {
    final boolean [][]given = { {false, true, false },
                                {false,  true, false },
                                {false, false, false},
                                {true, false,  true}}; 
    final boolean [][]expected = { {false, true, false},
                                   {false, false, false},
                                   {true,  true,  true},
                                   {true,  true,  true}}; 

    GameOfLifeBoard golb1 = new GameOfLifeBoard(4, 3);

    golb1.setBoard(given);
    GameOfLifeSimulator sim = new PlainGameOfLifeSimulator();
    sim.doStep(golb1);
   
    for (int i = 0; i < expected.length; i++) {
      for (int j = 0; j < expected[0].length; j++) {
        assertEquals(expected[i][j], golb1.getBoard()[i][j].getCellState());
      }
    }
  }
  
 // @Test
  void testCheckIfCellLives() {
    final boolean [][]board = { {false, true, false},
                                {true,  false,  false},
                                {false, true,  false}};
    final boolean [][]board2 = { {false, true, false},
                                 {true,  false,  false},
                                 {true, false,  false}};
    final boolean [][]board3 = { {false, true, false},
                                 {true,  true,  false},
                                 {false, false,  false}};
    final boolean [][]board4 = { {false, true, false},
                                 {true,  false,  true},
                                 {false, false,  false}};
    final boolean [][]board5 = { {false, true,  true},
                                 {true,  false,  false},
                                 {false, false,  false}};
    final boolean [][]board6 = { {false, true,  true},
                                 {false,  false,  true},
                                 {false, false,  false}};
    final boolean [][]board7 = { {false, false, false },
                                 {true,  false, false },
                                 {true, false,  true}};
    final boolean [][]board8 = { {true, true, false },
                                 {false,  true, false },
                                 {false, false,  false}};
    final boolean [][]board9 = { {true, true, false },
                                 {true,  true, false },
                                 {false, false,  false}};
    final boolean [][]board10 = { {true, false, false },
                                  {false,  false, false },
                                  {false, false,  false}};
    final boolean [][]board11 = { {true, true, false },
                                  {false,  false, false },
                                  {false, false,  false}};
    final boolean [][]board12 = { {true, true, true },
                                  {true,  true, false },
                                  {false, false,  false}};
    final boolean [][]board13 = { {true, true, true },
                                  {true,  true, false },
                                  {false, false,  true}};
    Point leftUpper = new Point(0, 0); 
    
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board2, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board3, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board4, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board5, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board6, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board7, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board8, leftUpper));
    assertTrue(PlainGameOfLifeSimulator.checkIfCellLives(board9, leftUpper));
    assertFalse(PlainGameOfLifeSimulator.checkIfCellLives(board10, leftUpper));
    assertFalse(PlainGameOfLifeSimulator.checkIfCellLives(board11, leftUpper));
    assertFalse(PlainGameOfLifeSimulator.checkIfCellLives(board12, leftUpper));
    assertFalse(PlainGameOfLifeSimulator.checkIfCellLives(board13, leftUpper));
  }


  //@Test
    void testCheckNeighbours() {
    //Given 
    
    //When
    boolean [][]b1 = { {false, false, false},
                       {false,  false,  true},
                       {false, false,  true}};
    
    boolean [][]b2 = { {false, true, false},
                       {true,  false,  false},
                       {false, false,  true}};
    
    boolean [][]b3 = { {false, true, false},
                       {true,  true,  true},
                       {false, false,  true}};
    
    boolean [][]b4 = { {false, true, false},
                       {false, true,  true},
                       {true, false,  true}};
   
    Point leftUpper = new Point(0, 0);
    Point rightMiddle = new Point(2, 1);
    Point middleMiddle = new Point(2, 1);

    //then aN == aliveNeighbours, u - left upper, m - right middle mM - middle middle
    final int aNu1 = PlainGameOfLifeSimulator.checkNeighbours(b1, leftUpper);
    final int aNu2 = PlainGameOfLifeSimulator.checkNeighbours(b2, leftUpper);
    final int aNu3 = PlainGameOfLifeSimulator.checkNeighbours(b3, leftUpper);
    
    final int aNm1 = PlainGameOfLifeSimulator.checkNeighbours(b1, rightMiddle);
    final int aNm2 = PlainGameOfLifeSimulator.checkNeighbours(b2, rightMiddle);
    final int aNm3 = PlainGameOfLifeSimulator.checkNeighbours(b3, rightMiddle);
    final int aNmM4 = PlainGameOfLifeSimulator.checkNeighbours(b4, middleMiddle);
    
    assertEquals(2, aNu1); 
    assertEquals(3, aNu2); 
    assertEquals(5, aNu3); 

    assertEquals(1, aNm1); 
    assertEquals(3, aNm2); 
    assertEquals(4, aNm3); 
    assertEquals(4, aNmM4); 
  }
  
  
}
