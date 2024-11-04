package projekt;

import java.awt.Point;

/**.
 * 
 */
public class PlainGameOfLifeSimulator implements GameOfLifeSimulator {
  /**.
  *  update the current GameOfLifeBoard instance
  *  based on its present state
  */
  @Override
  public void doStep(GameOfLifeBoard board) {
    final int rows = board.getBoard().length;
    final int cols = board.getBoard()[0].length;

    GameOfLifeCell[][] newBoard = new GameOfLifeCell[rows][cols];
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        newBoard[i][j] = new GameOfLifeCell();
      }
    }
    
    newBoard = board.getBoard();
    
    for (int r = 0; r < rows; r++) {

      for (int c = 0; c < cols; c++) {
        Point cell = new Point(c, r);
        if (checkIfCellLives(board, cell)) {
          newBoard[cell.y][cell.x].updateState(true); ; // the cell is alive
        } else {
          newBoard[cell.y][cell.x].updateState(false);; // the cell is dead
        }
      }
    }
    
    board.setBoard(newBoard);
  }
  
  /**.
   *
   * @param board - GameOfLifeBoard that will be used to check neighbours
   *        of the cell
   * @param cell - the cell to be checked
   * @return - the update state of the cell - alive(true) or dead(false)
   */
  public static boolean checkIfCellLives(GameOfLifeBoard board, Point cell) {
    int aliveNeighbours = 0;
    
    aliveNeighbours = checkNeighbours(board, cell);
   
    boolean cellLives = board.getBoard()[cell.y][cell.x].getCellState();
    if (!cellLives && (aliveNeighbours == 3)) {
      cellLives = true;
    } else if (cellLives && (aliveNeighbours > 1) && aliveNeighbours < 4) {
      // cell stays alive
    } else if (cellLives) {
      cellLives = false;
    } 
       
    return cellLives;

  }

  /**.
   *
   * @param board - a copy of the present state gameboard
   * @param cell - a point in the board which neighbours will be checked
   * @return - the number of alive neighbours
   */
  public static int checkNeighbours(GameOfLifeBoard board, Point cell) {
    int aliveNeighbours = 0;

    //we check the neighbours starting from upperleft relative position (-1, -1)
    for(int i = 0; i < 8 ; i++) {
      boolean neighbourIsAlive = board.getNeighboursValues(cell.y, cell.x, i); 
      if(neighbourIsAlive) {
        aliveNeighbours++;
      }
    }
    return aliveNeighbours;
  }
}
