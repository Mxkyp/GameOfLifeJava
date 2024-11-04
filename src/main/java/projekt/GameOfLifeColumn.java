package projekt;

/**.
 * 
 */
public class GameOfLifeColumn extends GameOfLifeDimension {
  /**.
   *
   * @param board - actualGameOfLifeBoard
   * @param columnX - the index of the wanted column
   */
  public GameOfLifeColumn(GameOfLifeCell[][] board, int columnX) {
    int rows = board.length;
    this.members = new GameOfLifeCell[rows];
    
    for (int i = 0; i < rows; i++) {
      this.members[i] = new GameOfLifeCell();
      this.members[i] = board[i][columnX];
    }
  }
}
