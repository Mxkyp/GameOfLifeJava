package projekt;

/**. a abstract class for golRow and golColumn
 * 
 */
public abstract class GameOfLifeDimension {
  protected GameOfLifeCell[] members;

  /**.
   *
   * @return amount of alive cells
   */
  public int countAliveCells() {
    int aliveCells = 0;

    for (int i = 0; i < members.length; i++) {
      boolean isAlive = members[i].getCellState();
      if (isAlive) {
        aliveCells++;
      }
    }
    
    return aliveCells;
  }
  
  /**.
   *
   * @return number of dead cells
   */
  public int countDeadCells() {
    int deadCells = 0;

    for (int i = 0; i < members.length; i++) {
      boolean isDead = !members[i].getCellState();
      if (isDead) {
        deadCells++;
      }
    }
    
    return deadCells;
  }
}
