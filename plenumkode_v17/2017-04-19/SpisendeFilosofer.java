import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SpisendeFilosofer {
    private static final int ANTALL_GAFLER = 5;
    private static final int ANTALL_FILOSOFER = ANTALL_GAFLER;
    public static void main(String[] args) {
        Gaffel[] gafler = new Gaffel[ANTALL_GAFLER];
        for (int i = 0; i < ANTALL_GAFLER; i++) {
            gafler[i] = new Gaffel(i);
        }

        for (int i = 0; i < ANTALL_FILOSOFER; i++) {
            Gaffel venstre = gafler[i];
            Gaffel hoyre = gafler[(i+1) % ANTALL_FILOSOFER];

            if (i == ANTALL_FILOSOFER - 1) {
                venstre = hoyre;
                hoyre = gafler[i];
            }

            Runnable filosof = new Filosof(i, venstre, hoyre);
            new Thread(filosof).start();
        }
    }
}

class Gaffel {
    private final Lock laas = new ReentrantLock();
    private final int id;

    public Gaffel(int id) {
        this.id = id;
    }

    public void plukkOpp(int filosofID) {
        laas.lock();
        System.out.println("Filosof " + filosofID + " plukket opp gaffel " + id);
    }

    public void leggNed(int filosofID) {
        laas.unlock();
        System.out.println("Filosof " + filosofID + " la ned gaffel " + id);
    }

}


class Filosof implements Runnable {
    private final int id;
    private final Gaffel venstre;
    private final Gaffel hoyre;

    public Filosof(int id, Gaffel venstre, Gaffel hoyre) {
        this.id = id;
        this.venstre = venstre;
        this.hoyre = hoyre;
    }

    public void run() {
        tenk();
        venstre.plukkOpp(id);
        try {
            Thread.sleep(1000);
            hoyre.plukkOpp(id);
            try {
                spis();
            }
            finally {
                hoyre.leggNed(id);
            }
        } catch (InterruptedException e) {}
        finally {
            venstre.leggNed(id);
        }
    }

    public void tenk() {
        System.out.println("Filosof " + id + " tenker");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch(InterruptedException e) {}
    }

    public void spis() {
        System.out.println("Filosof " + id + " spiser");
    }
}