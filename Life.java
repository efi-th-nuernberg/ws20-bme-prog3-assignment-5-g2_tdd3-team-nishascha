public class Life implements ILife {

  int [][] cellMatrix;
  
  public static void main(String[] args) 
  {

    // 5 Array Einträge á 5 Zeichen
   /* Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();
    */
  }

  public Life() {
    this.cellMatrix = new int[5][5];
    /*for (int y = 0; y < cellMatrix.length; y++){
      for (int x = 0; x < cellMatrix.length; x++){
        if (setup[y].charAt(x) != ' ')
          setAlive(x,y);
      }
    }
    */
  }


  @Override
  //setzt im gesamten Array alle Leerzeichen

    // TODO Auto-generated method stub

    public void nukeAll() {
    for(int y = 0; y < cellMatrix.length; y++){
      for(int x = 0; x < cellMatrix.length; x++){
        this.cellMatrix[x][y] = 0;
      }
    }

  }


  @Override
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub
    if(!checkAlive(x,y)){
      cellMatrix[x][y] = 1;
    }
    
  }

  @Override
  public void setDead(int x, int y) {

    if(checkAlive(x,y)){
      cellMatrix[x][y] = 0;
    }
  }


  /*checkt ob an der Position y,x ein 
  Leerzeichen ist wenn ja dann gibt die Methode
  false zurück, sprich die Zelle ist nicht am leben
  */
  public boolean checkAlive(int x, int y) {
    if(x < 0 || x >= 5){
      return false;
    }
    if(y < 0 || y >= 5){
      return false;
    }
    if (cellMatrix[x][y] != 0){
      return true;
    }
		return false;
	}


  @Override
  public ILife nextGeneration() {
    // TODO Auto-generated method 
    int[][] tempBoard = new int[5][5];
    for(int y = 0; y < cellMatrix.length; y++) {
     for(int x = 0; x < cellMatrix.length; x++) {
        if (checkAlive(x,y) == false && CellCount(x,y) == 3){
          tempBoard[x][y] = 1;
        }
        else if (checkAlive(x,y) == true && (CellCount(x,y) < 2  || CellCount(x,y) > 3)){
          tempBoard[x][y] = 0;
        }
        else if (checkAlive(x,y) == true && (CellCount(x,y) == 2 || CellCount(x,y) == 3)){
          tempBoard[x][y] = 1;
     }
    }
    }
    cellMatrix = tempBoard;  
    return null;
  }


/*zählt alle Nachbarzellen und gibt die Anzahl wieder, auf den Rückgabewert (int) basieren 
die setAlive und setDead Methoden*/
public int CellCount (int x, int y){
    int counter = 0;
		if (checkAlive(x-1, y-1))
			counter++;
		if (checkAlive(x, y-1))
			counter++;
		if (checkAlive(x+1, y-1))
			counter++;
		if (checkAlive(x-1, y))
			counter++;
		if (checkAlive(x+1, y))
			counter++;
		if (checkAlive(x-1, y+1))
			counter++;
		if (checkAlive(x, y+1))
			counter++;
		if (checkAlive(x+1, y+1))
			counter++;
    return counter;
}
}
/*public void initMatrix(String[] setup) {
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

private void printMatrix(int[][] setup) {
		// TODO Auto-generated method stub
		int lines = setup.length;
		int columns = setup.length;

		for (int i = 0; i < lines; i++) {
			System.out.print(i + "  |");
			for (int j = 0; j < columns; j++) {
				System.out.print(" " + cellMatrix[i][j] + " |");
			}
			if (i != lines) {
				System.out.print("\n");
			}
		}
	}

}

*/



/* if cell isAlive check all eight directions
count all cells, if CellCount <2 then set dead, if CellCount>3 then set dead


if cell isDead, count how may neighbour cells are alive, if CellCount = 3, dead-cell isAlive, if != no cell will be generated


 */