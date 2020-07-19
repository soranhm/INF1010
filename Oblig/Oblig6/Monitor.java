
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Monitor{
    public int ferdigTelegraf = 0;
    public int ferdigKryptograf = 0;
    public int antallProdusenter,antallKonsumenter,ferdigProdusenter,ferdigKonsumenter;

    Liste<Melding> meldinger = new Koe<Melding>();

    private Lock lock = new ReentrantLock();
    private final Condition isemty = lock.newCondition();

    public Monitor(int produsenter, int konsumenter){
        this.antallProdusenter = produsenter;
        this.antallKonsumenter = konsumenter;
    }

    public void sett(Melding mmm){
        lock.lock();
        try{
            meldinger.settInn(mmm);
            isemty.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
    public Melding hent(){
        lock.lock();
        try{
            while(meldinger.erTom() && !alleP()){
                isemty.await();
            }
            return meldinger.fjern();
        }
        catch(InterruptedException e){}
        finally{
            lock.unlock();
        }
        return null;
    }

    public void ferdigP(){
        ferdigProdusenter++;
    }

    public void ferdigK(){
        ferdigKonsumenter++;
    }

    public boolean alleP(){
        return ferdigProdusenter == antallProdusenter;
    }

    public boolean alleK(){
        return ferdigKonsumenter == antallKonsumenter;
    }
}
