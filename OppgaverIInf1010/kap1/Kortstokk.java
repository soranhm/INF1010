import java.util.Random;
import java.util.ArrayList;

class Kortstokk {
  private ArrayList<Kort> kortstokk = new ArrayList<>();
  private Random trekker;
  private String[] farger = {"H", "K", "S", "R"};

  public void sorter(){
    for (int i = 0; i < farger.length;i++){
      for(int j = 1 ; j < 14;j++){
        kortstokk.add(farger[i]+j);
      }
    }
  }
  public void trekkKort(){
    int indeks = trekker.nextInt(kortstokk.size());
  }
}
