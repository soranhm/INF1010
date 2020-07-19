import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class TelefonkioskEksempel {
    public static void main(String[] args) {
        Telefonkiosk kiosk = new Telefonkiosk();

        String[] navn = {"Arne", "Bjarte", "Cecilie", "Daniel", "Emil"};

        for(String s : navn) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    kiosk.brukTelefon(s);
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                kiosk.reparerTelefon();
            }
        }).start();
    }
}

class Telefonkiosk {
    private final Lock laas = new ReentrantLock();
    private final Condition kanBrukes = laas.newCondition();
    private final Condition trengerService = laas.newCondition();
    private static final int MAKS_ANTALL_BRUK = 5;
    private int brukTeller = 2;

    public void brukTelefon(String navn) {
        System.out.println(navn + " vil bruke telefonkiosken");
        laas.lock();
        try {
            // sjekk om det er mulig å ringe
            while(brukTeller == MAKS_ANTALL_BRUK) {
                System.out.println(navn + " venter mens kiosken er ute av stand");
                kanBrukes.await();
            }

            // bruk telefonen
            System.out.println(navn + " ringer");
            brukTeller++;

            if (brukTeller == MAKS_ANTALL_BRUK) {
                System.out.println(navn + " har fylt opp beholder, tilkaller service");
                // telefonen tilkaller reperatør
                trengerService.signal();
            }
        }
        catch(InterruptedException e) {}
        finally {
            laas.unlock();
        }
    }

    public void reparerTelefon() {
        System.out.println("Reparator har ankommet stedet");
        laas.lock();

        try {
            while(brukTeller < MAKS_ANTALL_BRUK) {
                trengerService.await();
            }

            System.out.println("Reparator fikser telefonkiosken");
            brukTeller = 0;

            kanBrukes.signalAll();
        }
        catch(InterruptedException e) {}
        finally {
            laas.unlock();
        }
    }
}