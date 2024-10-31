// Made by Mikołaj Pawłoś (258681)
// and Mikita Karabeika (252496)

package projekt;

/**.
 * example turn of GameOfLife
 */
public class Game {
  public static final int rows = 5;
  public static final int cols = 5;
  public static final int iterations = 3;

  /**.
   *
   * @param args - unused 
   */
  public static void main(String[] args) {

    GameOfLifeBoard gameBoard = new GameOfLifeBoard(rows, cols);

    final boolean [][]toImport = { {false, false, false, true, true},
                                   {true,  true, false, false, true },
                                   {true, false,  false, false, false},
                                   {false, false, false, false, false}, 
                                   {false, true, false, true, false} };
    gameBoard.setBoard(toImport);
    
    for (int i = 0; i < iterations; i++) {
      
      System.out.printf("%-3d - ITERATION\n", i);
      gameBoard.printBoard();
      gameBoard.doSimulationStep();
    }
  }
  
  
}
