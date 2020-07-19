class Rack {

  // lager varibalene som blir brukt i denne klassen
  private Node[] noder;
  private int teller;

  // lager en metode som setter lengden paa noden
  public void setLengde(int l) {
    noder = new Node[l];

  }

  // lager en metode som lagrer noden i array
  public void lagreNoder(Node node) {
    for ( int i = 0; i < noder.length;i++){
      if (noder[i] == null ) {
        noder[i] = node;
        return;
      }
    }
  }

  // lager en boolean konstroktor som tester om det er fult eller ikke fult array
  public boolean erFull(){
    if (noder[(noder.length-1)]== null) {
      return false;
    }
    return true;
  }

  // lager en konstroktor som tar in minstMinne og finner ut antallet
  public int noderMedNokMinne(int paakrevdMinne){
    teller = 0;
    for (int i = 0 ;i < (noder.length);i++){
      if (noder[i] != null && noder[i].getMinne() >= paakrevdMinne ) {

        teller++;
      }
    }
    return teller;
  }

  // lager et get konstroktor som returnere en del av Flopsen
  public double getFlops(){
    double teller = 0;
    for (int i = 0; i < noder.length;i++){
      if (noder[i] != null){
        teller += noder[i].getFlops();
      }
    }
    return teller;
  }

}
