// 4b
class Bestilling{
  String varenavn;
  CountDownLatch latch;
  String svar;

  public Bestilling(String varenavn, CountDownLAtch latch){
    this.varenavn = varenavn;
    this.latch = latch;
  }
}

// 4c
class Bestillingsbeholder {
  private final ArrayList<Bestilling> bestillinger = new ArrayList<Bestilling>();
  private final Lock laas = new ReentrantLock();
  private final Condition bestillingFinnes = laas.newCondition();

  public void LeggInn(Bestilling bestilling){
    laas.lock();
    try{
        bestillinger.add(bestilling); // setter inn bakerst
        bestillingFinnes.signalAll();
    }
    finally{
        laas.unlock();
    }
  }

  public Bestilling hentBestilling() {
    laas.lock();
    try{
        while (bestillinger.size() == 0) {
          bestillingFinnes.await();
        }
        return bestillinger.remove(0); // fjerner forste som ble satt inn
    }
    catch (InterruptedException e) {
      return null;
    }
    finally{
      laas.unlock();
    }
  }
}

// 4d

class Kunde implements Runnable {
  String varenavn;
  Bestillingsbeholder bestillinger;

  public Kunde(String varenavn,Bestillingsbeholder bestillinger){
    this.varenavn = varenavn;
    this.bestillinger = bestillinger;
  }

  public void run() {
    CountDownLatch latch = new CountDownLatch(1);
    Bestilling bestilling = new Bestilling(varenavn,latch);
    bestillinger.leggInn(bestilling);
    try {
      latch.await();
    }
    catch (InterruptedException e) {}
    System.out.println(bestilling.svar);
  }
}

// 4e

class Ansatt implements Runnable{
  Bestillingsbeholder bestillinger;
  VareRegister register;

  public Ansatt(Bestillingsbeholder bestillinger,VareRegister register){
    this.bestillinger = bestillinger;
    this.register = register;
  }

  public void run(){
    while(true){
      Bestilling best = bestillinger.hentBestilling();
      String svar = register.leie(best.varenavn);
      best.svar = svar;
      best.latch.countDown();
    }
  }
}
