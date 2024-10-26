package projekt;

import java.awt.Point;

/**.
 * da
 */
public class PlainGameOfLifeSimulator implements GameOfLifeSimulator {
  /**.
  *  update the current GameOfLifeBoard instance
  *  based on its present state
  */
  @Override
  public void doStep(GameOfLifeBoard board) {
    boolean [][] newBoard = board.getBoard();
    final int rows = newBoard.length;
    final int cols = newBoard[0].length;
    
    for (int r = 0; r < rows; r++) {

      for (int c = 0; c < cols; c++) {
        Point cell = new Point(c, r);
        if (checkIfCellLives(board.getBoard(), cell)) {
          newBoard[cell.y][cell.x] = true; // the cell is alive
        } else {
          newBoard[cell.y][cell.x] = false; // the cell is dead
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
  public static boolean checkIfCellLives(boolean[][] board, Point cell) {
    int aliveNeighbours = 0;
    
    aliveNeighbours = checkNeighbours(board, cell);
   
    boolean cellLives = board[cell.y][cell.x];
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
  public static int checkNeighbours(boolean[][] board, Point cell) {
    final int rows = board.length;
    final int cols = board[0].length;
    int aliveNeighbours = 0;

    //we check the neighbours starting from upperleft relative position (-1, -1)
    for (int r = -1; r <= 1; r++) {

      int y = (cell.y + r + rows) % rows;

      for (int c = -1; c <= 1; c++) {

        int x = (cell.x + c + cols) % cols;
        Point neighbour = new Point(x, y);
        
        if (board[neighbour.y][neighbour.x] && !neighbour.equals(cell)) {
          aliveNeighbours++;
        }
      }
    }
    return aliveNeighbours;
  }
}
