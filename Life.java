public class Life implements ILife {
  
  public static void main(String[] args) 
  {

    // 5 Array Einträge á 5 Zeichen
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();
  }


  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++){
      for (int x = 0; x < setup[y].length(); x++){
        if (isAlive(x,y))
          setDead(x, y);
        if (!isAlive(x,y))
          setAlive(x,y);
      }
    }
  }


  @Override
  //setzt im gesamten Array alle Leerzeichen
  public void nukeAll() {
    // TODO Auto-generated method stub
    for (int y = 0; y < setup.length; y++){
      for (int x = 0; x < setup[y].length(); x++){
        setup[y].charAt(x).add(' ');
      }
    }

  }

  @Override
  //setzt an der Stelle, y,x ein Asterisk
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub

    /* Wenn Leerzeichen und Nachbarzellen = 3 
    dann lebend setzen
    */
    if(!isAlive(x,y) && CellCount(x,y) == 3){
      setup[y].charAt(x).add('*');
    }
  }

  @Override
  // setzt an der Stelle y,x ein Leerzeichen
  public void setDead(int x, int y) {

    /*Wenn Zelle am leben und Nachbarzellen
    kleiner 2 oder größer 3 sind, stirbt die Zelle
    an der Stelle x,y
    */
    if(isAlive(x,y) && (CellCount(x,y)<2 || CellCount(x,y)>3)){
    setup[y].charAt(x).add(' ');
    }
  }

  @Override
  /*checkt ob an der Position y,x ein 
  Leerzeichen ist wenn ja dann gibt die Methode
  false zurück, sprich die Zelle ist nicht am leben
  */
  public boolean isAlive(int x, int y) {
    if (setup[y].charAt(x) != ' '){
      return true;
    }
		return false;
	}

  @Override
  public ILife nextGeneration() {
    // TODO Auto-generated method stub
    return null;
  }


/*zählt alle Nachbarzellen und gibt die Anzahl wieder, auf den Rückgabewert (int) basieren 
die setAlive und setDead Methoden*/
  public int CellCount (int x,int y){
    int counter = 0;
		if (isAlive(x-1, y-1))
			counter++;
		if (isAlive(x-1, y))
			counter++;
		if (isAlive(x-1, y+1))
			counter++;
		if (isAlive(x, y-1))
			counter++;
		if (isAlive(x, y+1))
			counter++;
		if (isAlive(x+1, y-1))
			counter++;
		if (isAlive(x+1, y))
			counter++;
		if (isAlive(x+1, y+1))
			counter++;
		return counter;
  }
}




/* if cell isAlive check all eight directions
count all cells, if CellCount <2 then set dead, if CellCount>3 then set dead


if cell isDead, count how may neighbour cells are alive, if CellCount = 3, dead-cell isAlive, if != no cell will be generated


 */