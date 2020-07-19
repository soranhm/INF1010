class Eskemaker implements Runnable{
  public static int cnt = 0;
  private int id;
  private Lager lager;
  private int skalLage;

  Eskemaker(Lager l,int ant){
    skalLage = ant;
    lager = l;
    cnt++;
    id = cnt;
  }

  public void run(){
    for (;skalLage> 0 ;skalLage-- ) {
      lager.settInn(id);
      try{
        Thread.sleep(2000);
      }catch(InterruptedException e){
        System.out.println("UVENTET ESKEMAKER AVBRUDD");}
    }
    System.out.println("ESKEMAKER NR "+ id + " ER FERDIG");
  }
}
