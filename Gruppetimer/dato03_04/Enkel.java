class Enkel{
  public static void main(String[] args) {
    Traad1 t = new Traad1();
    t.start();
    for (int i = 0; i < 10; i++) {
      System.out.println("Main: " + i);
    }
  }
}

class Traad1 extends Thread {
  public void run(){
    System.out.println("Traad nr 1 starter");
    for (int i = 0;i < 10 ;i++ ) {
      System.out.println("Traad: "+ i);
    }
  }
}
