
class Node {
  // lager varibalene som blir brukt i denne klassen
  private int minne;
  private double hz;
  private Prosessor prosEn;
  private Prosessor prosTo;

  // lager en konstroktor som tar info om 1 prossesor og minne
  public Node(int minneStorrelse,double klokke, int kjerne){
    minne = minneStorrelse;
    hz = klokke;
    prosEn = new Prosessor(kjerne,klokke);
}

  // lager en konstroktor som tar info om 2 prossesor og minne
  public Node(int minneStorrelse,double klokke,int kjerne,double klokke2, int kjerne2){

    minne = minneStorrelse;
    hz = klokke;
    prosEn = new Prosessor(kjerne,klokke);
    prosTo = new Prosessor(kjerne2,klokke2);
  }

  // lager et get konstroktor som returnere en del av Flopsen
  public double getFlops(){

    // if test som regner ut flops for med og uten 2 Prosessor
    if (prosTo != null) {
      return prosEn.getFlops() + prosTo.getFlops();
    }
    return prosEn.getFlops();
  }
  // lager get konstroktor som kan sende minne videre
  public int getMinne() {
    return minne;
  }

}
