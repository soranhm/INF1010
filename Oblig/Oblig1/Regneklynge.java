//importere ArrayList
import java.util.ArrayList;

class Regneklynge {

  // lager varibalen og ArrayListen som blir brukt i denne klassen
  ArrayList<Rack> rack = new ArrayList<>();
  private int rackLengde;


  // lager en konstroktor som oppgir lengden pa racken
  public Regneklynge(int rL){
    rackLengde = rL;
  }

  // lager en metode som setter inn noder i racken
  public void settInnNode(Node node) {
    for (Rack r: rack) {

      //kjorer gjennom helle ArrayListen og setter inn node der det er plass
      if (!r.erFull()) {
        r.lagreNoder(node);
        return;
      }
    }

    // lager ny ArrayList hvis fult/tomt
    Rack nyR = new Rack();
    nyR.setLengde(rackLengde);
    rack.add(nyR);
    nyR.lagreNoder(node);
  }
  // lager en get konstroktor som tar inn minne og finner antall minst minne
  public int getMinne(int minne){
    int  minneS = 0;
   for (Rack r: rack){
     minneS += r.noderMedNokMinne(minne);
   }
   return minneS;
   }

  // lager en get konstroktor som regner ut flops
  public double getflops() {
    double  floo = 0;
    for (Rack r: rack){
      floo += r.getFlops();
    }
    return floo;
    }

  // lager en get konstroktor som regner ut antall rack
  public int getStorrelse(){
      return rack.size();
    }

}
