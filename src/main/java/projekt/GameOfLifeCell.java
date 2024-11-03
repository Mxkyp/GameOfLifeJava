package projekt;

/**.
 * represents a singular GOL board cell
 * holds references to neighbouring cells
 */
public class GameOfLifeCell {
  private boolean isAlive;
  private GameOfLifeCell[] neighbours;
  
  public GameOfLifeCell() {
    this.isAlive = false;
    this.neighbours = new GameOfLifeCell[8];
  }

  public boolean getCellState() {
    return this.isAlive;
  }

  public void setNeighbours(GameOfLifeCell[] neighbours) {
    this.neighbours = neighbours.clone();
  }

  public boolean getNeighbourState(int hisIndex) {
    return this.neighbours[hisIndex].getCellState();
  }

  public void updateState(boolean newState) {
    this.isAlive = newState;
  }
  
  
}
