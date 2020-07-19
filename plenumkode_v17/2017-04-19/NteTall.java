import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class NteTall {
    public static void main(String[] args) {
        Monitor m = new Monitor();
        for (int start = 0; start < 10; start++) {
            new Thread(new OppgaveD(10, start, 50, m)).start();
        }
    }
}

class Monitor {
    Lock laas = new ReentrantLock();
    Condition kanFortsette = laas.newCondition();
    int nesteTall = 0;

    public void skrivUtTall(int tall) {
        laas.lock();
        try {
            while (tall != nesteTall) {
                kanFortsette.await();
            }

            System.out.println(tall);
            nesteTall++;
            kanFortsette.signalAll();

        }
        catch(InterruptedException e) {}
        finally {
            laas.unlock();
        }
    }
}

class OppgaveD implements Runnable {
    private final int n, start, maks;
    private final Monitor m;

    public OppgaveD(int n, int start, int maks, Monitor m) {
        this.n = n;
        this.start = start;
        this.maks = maks;
        this.m = m;
    }

    public void run() {
        for (int i = start; i < maks; i += n) {
            m.skrivUtTall(i);
        }
    }
}

class OppgaveB implements Runnable {
    private final int n, start, maks;
    public OppgaveB(int n, int start, int maks) {
        this.n = n;
        this.start = start;
        this.maks = maks;
    }

    public void run() {
        for (int i = start; i < maks; i += n) {
            System.out.println(i);
        }
    }
}

class OppgaveA implements Runnable {
    public void run() {
        for (int i = 5; i < 1000; i += 10) {
            System.out.println(i);
        }
    }
}
