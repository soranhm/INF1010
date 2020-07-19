public class PC {
    String merke;
    int serienummer;
    private static int seriehittil = 10000;

    public PC(String merke) {
        this.merke = merke;
        this.serienummer = seriehittil;
        seriehittil++;
    }

    public int hentSerienummer() {
        return serienummer;
    }

    public static int hentSeriehittil() {
        return seriehittil;
    }

    static class Inni {
        int ikkeStatiskInt;

        Inni(int i) {
            ikkeStatiskInt = i;
            // Dette funker ikke
            // System.out.println(serienummer);
            // Men dette funker fordi seriehittil er static:
            System.out.println(seriehittil);
            System.out.println("Det funket");
        }
    }
}
