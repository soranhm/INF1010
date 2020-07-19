class Arbeider implements Runnable{
  public static int cnt = 0;
  private int id;
  private Lager lager;

  Arbeider(Lager l){
    lager = l;
    cnt++;
    id = cnt;
  }

  public void run(){
    while(true){
      lager.taUt();
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){System.out.println("UVENTET ARBEIDER AVBRUDD");}

    }
  }
}
