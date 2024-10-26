package projekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

/**.
 * 
 */
public class GameTest {
  @Test
  void testMain() {
    Game test = new Game();
    assertTrue(test.rows == Game.rows);
    OutputStream os = new ByteArrayOutputStream();
    PrintStream stream = new PrintStream(os);
    System.setOut(stream);
    
    Game.main(null);
    String actualOutput = os.toString();
    String expectedOutput = "0   - ITERATION\n"
        + "0 0 0 1 1 \n"
        + "1 1 0 0 1 \n"
        + "1 0 0 0 0 \n"
        + "0 0 0 0 0 \n"
        + "0 1 0 1 0 \n"
        + "1   - ITERATION\n"
        + "0 1 0 1 0 \n"
        + "0 1 0 1 0 \n"
        + "1 1 0 0 1 \n"
        + "0 0 0 0 0 \n"
        + "0 0 1 1 1 \n"
        + "2   - ITERATION\n"
        + "1 1 0 0 0 \n"
        + "0 1 0 1 0 \n"
        + "1 1 1 0 1 \n"
        + "0 1 1 0 0 \n"
        + "0 0 1 1 1 \n"
        + "";
    assertEquals(expectedOutput, actualOutput);
  }
}
