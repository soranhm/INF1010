public interface Kjorbar {
    int fart();
}

public interface Kjoretoy extends Kjorbar {
    String hentRegnr();
}

public class Bil implements Kjoretoy {
    String hentRegnr();
    int fart(){...}
}

public class Baat implements Kjorbar {
    int fart(){}
}