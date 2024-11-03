package projekt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**.
 * unit tests
 */
public class GameOfLifeCellTest {
  @Test
  void testInit() {
    GameOfLifeCell cell = new GameOfLifeCell();

    assertEquals(false, cell.getCellState());
  }
  
  @Test
  void testUpdateState() {
    GameOfLifeCell cell = new GameOfLifeCell();
    cell.updateState(true);
    
    assertEquals(true, cell.getCellState());
  }

  @Test
  void testGetCellState() {
    GameOfLifeCell cell = new GameOfLifeCell();

    cell.updateState(true);
    assertEquals(true, cell.getCellState());

    cell.updateState(false);
    assertEquals(false, cell.getCellState());
  }

  @Test
  void testSetNeighbours() {
    GameOfLifeCell[] neighbours = new GameOfLifeCell[8];
    GameOfLifeCell cell = new GameOfLifeCell();
    
    for (int i = 0; i < 8; i++) {
      neighbours[i] = new GameOfLifeCell();
      neighbours[i].updateState(true); 
    }

    cell.setNeighbours(neighbours);
    neighbours[0].updateState(false);

    assertEquals(false, neighbours[0].getCellState());
    assertEquals(neighbours[0].getCellState(), cell.getNeighbourState(0));

    for (int i = 1; i < 8; i++) {
      assertEquals(neighbours[i].getCellState(), cell.getNeighbourState(i));
    }
  }
  
}
