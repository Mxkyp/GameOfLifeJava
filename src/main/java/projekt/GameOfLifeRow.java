package projekt;

/**.
 * 
 */
public class GameOfLifeRow extends GameOfLifeDimension {
  /**.
   *
   * @param board - actualGameOfLifeBoard
   * @param rowY - the index of the wanted row
   */
  public GameOfLifeRow(GameOfLifeCell[][] board, int rowY) {
    int cols = board[0].length;
    this.members = new GameOfLifeCell[cols];
    
    for (int i = 0; i < cols; i++) {
      this.members[i] = new GameOfLifeCell();
      this.members[i] = board[rowY][i];
    }
  }
}