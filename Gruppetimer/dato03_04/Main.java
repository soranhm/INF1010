import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Main {
  public static void main(String[] args) {
    Runnable task = new MyTask();
    Thread worker1 = new Thread(task);
    Thread worker2 = new Thread(task);
    worker1.start();  // Will make a call to task.run()
    worker2.start();
  }
}

class MyTask implements Runnable{
  private final Lock lock  = new ReentrantLock();
  private final int MAX_COUNT = 10000;
  private int sharedCounter = 0;

  public void run(){
    System.out.println("Starting! shared counter = " + sharedCounter);
    for (int i = 0;  i < MAX_COUNT; i++) {
        lock.lock();
        try{
          sharedCounter = sharedCounter + 1;
        } finally{ lock.unlock();}
    }
    System.out.println("Done! shared counter = " + sharedCounter);
  }
}

/*
try{

}catch(){


}finally{

}*/
