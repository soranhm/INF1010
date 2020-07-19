import java.util.concurrent.locks.*;


class Lager{
  private Lock laas = new ReentrantLock();
  private Condition full = laas.newCondition();
  private Condition tom = laas.newCondition();

  private final int lagerplass;
  private int antEsker = 0;


  Lager(int ant){
    lagerplass = ant;
  }

  public void taUT(int id){
    laas.lock();
    try{
      while(antEsker == 0) {
        tom.await();
      }
      antEsker--;
      System.out.println("Arbeider nr " + id + " tar ut eske...");
      full.signalAll();
    }catch(InterruptedException e){
      System.out.println("UVENTET ARBEIDER AVBRUDD");
    }finally{ laas.unlock();}
  }

  public void settInn(int id){
    laas.lock();
    try{
      while(antEsker == lagerplass) {
        full.await();
      }
      antEsker++;
      System.out.println("Eskemaker nr " + id + " setter inn eske...");

      tom.signalAll();
    }catch(InterruptedException e){
      System.out.println("UVENTET ARBEIDER AVBRUDD");
    }finally{ laas.unlock();}

  }
}
