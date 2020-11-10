import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.checkAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {
      //assertTrue(!setAlive);
    }


    @Test
    public void keepAliveCell() {
      //assertTrue(setAlive);
    }


    @Test
    public void destroyCrowdedCell() {
      //assertTrue(CellCount>3);
    }

  int cellMatrix[][] = new int[5][5];
   String setup[] = new String[]{      "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " };

/*@Test
public void initMatrix() {
for(int i = 0; i < setup.length; i++) {
    for(int j = 0; j < setup[i].length(); j++) {
      if(setup[i].charAt(j) == ' ') {
        cellMatrix[i][j] = 0;
      }
      if(setup[i].charAt(j) == '*') {
        cellMatrix[i][j] = 1;
      }
    }
  }
}

@Test
private void printMatrix() {
		// TODO Auto-generated method stub
		int lines = setup.length;
		int columns = setup.length;

		for (int i = 0; i < lines; i++) {
			System.out.print(i + "  |");
			for (int j = 0; j < columns; j++) {
				System.out.print(" " + cellMatrix(i, j) + " |");
			}
			if (i != lines) {
				System.out.print("\n");
			}
		}
	}

*/
                   
                                


}