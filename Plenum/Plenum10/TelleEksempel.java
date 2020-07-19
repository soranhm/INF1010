public class TelleEksempel{
  public static void main(String[] args) {
    Runnable telleJobb = new TelleJobb();
    Thread t1 = new Thread(telleJobb);
    Thread t2 = new Thread(telleJobb);
    //Thread t1 = new TelleTread();
    //Thread t2 = new TelleTread();

    t1.start();
    t2.start();

    try{
    Thread.sleep(1000);
    } catch(InterruptedException e){}

    t1.interrupt();
    t2.interrupt();

  }
}

class TelleTread extends Thread{
    @Override
    public void run(){
      int teller = 0;
      while(!interrupted()){
        teller++;
      }
      System.out.println("TEete til " + teller);
    }
}


class TelleJobb implements Runnable{
  public void run(){
    int teller = 0;
    while(!Thread.interrupted()){
      teller++;
    }
    System.out.println("TEete til " + teller);
  }
}
