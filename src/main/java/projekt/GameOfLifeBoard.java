package projekt;

import java.util.Arrays;
import java.util.Random;

/**.
 * 
 */
public class GameOfLifeBoard {
  private GameOfLifeCell[][] board;
  
  public void doSimulationStep() {
    GameOfLifeSimulator gameOfLifeSimulator = new PlainGameOfLifeSimulator();
    gameOfLifeSimulator.doStep(this);
  }

  /**. 
   * construct a GameOfLifeBoard with given size, random values
   *
   * @param n - rows
   * @param m - cols 
   */
  public GameOfLifeBoard(int n, int m) {
    Random r = new Random();

    this.board = new GameOfLifeCell[n][m];
    
    for (int i = 0; i < n; i++) {
      
      for (int j = 0; j < m; j++) {
        this.board[i][j] = new GameOfLifeCell();
        this.board[i][j].updateState(r.nextBoolean()); ;
      }
    }

    for (int i = 0; i < n; i++) {
      
      for (int j = 0; j < m; j++) {
        this.assignNeighboursTo(i, j);
      }
    }
  }

  /**.
   * construct a GameOfLifeBoard with def size, random values  
   */
  public GameOfLifeBoard() {
    Random r = new Random();
    final int def = 10;
    this.board = new GameOfLifeCell[def][def];
    
    for (int i = 0; i < def; i++) {
      
      for (int j = 0; j < def; j++) {
        this.board[i][j] = new GameOfLifeCell();
        this.board[i][j].updateState(r.nextBoolean()); ;
      }
    }

    for (int i = 0; i < def; i++) {
      
      for (int j = 0; j < def; j++) {
        this.assignNeighboursTo(i, j);
      }
    }
  }
  
  /**.
   * assign 8 neighbours to the cell
   *
   * @param y_index - y position in the board
   * @param x_index - x position in the board
   */
  private void assignNeighboursTo(int cellY, int cellX) {
    final int rows = this.board.length;
    final int cols = this.board[0].length;
    GameOfLifeCell[] neighbours = new GameOfLifeCell[8];
    int counter = 0;
    for (int r = -1; r <= 1; r++) {

      int y = (cellY + r + rows) % rows;

      for (int c = -1; c <= 1; c++) {

        int x = (cellX + c + cols) % cols;
        
        if (y != cellY || x != cellX) {
          neighbours[counter] = new GameOfLifeCell();
          neighbours[counter] = this.board[y][x];
          counter++;
        }
      }
    }
    
    this.board[cellY][cellX].setNeighbours(neighbours);
  }

  public boolean getNeighboursValues(int cellY, int cellX, int neighIndex) {
    return this.board[cellY][cellX].getNeighbourState(neighIndex);
  }

  /**.
  *
  * @return a hardcopy of the board member of a given instance
  */
  public GameOfLifeCell[][] getBoard() {
    final int rows = this.board.length;
    final int cols = this.board[0].length;
    GameOfLifeCell[][] independentCopy = new GameOfLifeCell[rows][cols];
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        independentCopy[i][j] = new GameOfLifeCell();
        independentCopy[i][j].updateState(this.board[i][j].getCellState()); 
      }
    }
    
    return independentCopy;
  }

  /**.
   * creates a hardcopy of a example cells state board
   * and assign it to the board member
   *
   * @param templateBoard -
   */
  public void setBoard(boolean[][] templateBoard) {
    final int row = templateBoard.length;
    final int col = templateBoard[0].length;

    boolean[][] independentCopy = new boolean[row][];
    
    for (int i = 0; i < row; i++) {
      independentCopy[i] = Arrays.copyOf(templateBoard[i], col);
    }
    
    for (int i = 0; i < row; i++) {

      for (int j = 0; j < col; j++) {
        this.board[i][j].updateState(independentCopy[i][j]);
      }
    }
  }

  /**.
   *
   * @param templateBoard - an golb to be copied
   */
  public void setBoard(GameOfLifeCell[][] templateBoard) {
    final int row = templateBoard.length;
    final int col = templateBoard[0].length;

    boolean[][] independentCopy = new boolean[row][];
    
    
    for (int i = 0; i < row; i++) {

      for (int j = 0; j < col; j++) {
        boolean copied =  templateBoard[i][j].getCellState();
        this.board[i][j].updateState(copied);
      }
    }
  }

  /**.
   * prints the given board
   * (I do not think its practice to impose javadoc comments on
   * all methods because i think we can agree this one 
   * is pretty much self-explainatory)
   */
  public void printBoard() {

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        char toPlace = '0';
        boolean isAlive = this.board[i][j].getCellState();
        if (isAlive) {
          toPlace = '1';
        }
        System.out.printf("%c ", toPlace);
      }
      System.out.print('\n');
    }
  }
  
}