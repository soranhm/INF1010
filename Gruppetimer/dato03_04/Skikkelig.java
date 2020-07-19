class Skikkelig{
  public static void main(String[] args) {
    Traad2 t = new Traad2();
    new Thread(t).start();
    for (int i = 0; i< 10; i++) {
      System.out.println("Main: " + i);
    }
  }
}


class Traad2 implements Runnable {
  public void run(){
    System.out.println("Traad nr 1 starter");
    for (int i = 0;i < 10 ;i++ ) {
      System.out.println("Traad: "+ i);
      try{Thread.sleep(2000);} // 2 sek
      catch(InterruptedException e){}
    }
  }
}
