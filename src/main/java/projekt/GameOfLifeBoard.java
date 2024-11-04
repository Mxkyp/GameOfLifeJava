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
   * creates a hardcopy of a given board,
   * and assign it to the board member
   *
   * @param templateBoard -
   */
  public void setBoard(boolean[][] templateBoard) {
    boolean[][] independentCopy = new boolean[templateBoard.length][];
    
    for (int i = 0; i < templateBoard.length; i++) {
      independentCopy[i] = Arrays.copyOf(templateBoard[i], templateBoard[i].length);
    }
    
   // this.board = independentCopy;
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
     // if (board[i][j] == true) {
          toPlace = '1';
      //  }
     //   System.out.printf("%c ", toPlace);
      }
      System.out.print('\n');
    }
  }
  
}