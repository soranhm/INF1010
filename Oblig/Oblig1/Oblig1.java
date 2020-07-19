
class Oblig1 {
  public static void main(String[] args) {


    // lager en objekt ut fra Regneklynge klassen og setter rackLengde = 12
    Regneklynge rk = new Regneklynge(12);

    // lager 650 noder med oppgit info
    for (int i = 0; i < 650;i ++){
      Node n = new Node(64,2.6,8,2.6,8);
      rk.settInnNode(n);
    }
    // lager 16 noder med annerledes info
    for (int i = 0; i < 16 ; i++){
      Node n = new Node(1024,2.3,8,2.3,8);
      rk.settInnNode(n);
    }

    // Skriver ut alt til terminal
    System.out.println("samlet FLOPS: " +   rk.getflops());
    System.out.println("Noder med minst 32 GB: " + rk.getMinne(32));
    System.out.println("Noder med minst 64 GB: " + rk.getMinne(64));
    System.out.println("Noder med minst 128 GB: " + rk.getMinne(128));
    System.out.println("Antall rack: " + rk.getStorrelse());

  }
}
