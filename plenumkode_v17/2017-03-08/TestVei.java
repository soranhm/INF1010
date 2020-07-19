public class TestVei {
    public static void main(String[] args) {
        Vei<Kjoretoy> allfarvei = new Vei<Kjoretoy>();
        Buss buss = new Buss("BU12345");
        Bil bil = new Bil("BI12345");
        Sykkel sykkel = new Sykkel("Kåre");
        Bil bil2 = new Bil("AA123");

        allfarvei.kjorInnPaaVei(buss);
        allfarvei.kjorInnPaaVei(bil);
        allfarvei.kjorInnPaaVei(sykkel);
        allfarvei.kjorInnPaaVei(bil2);

        allfarvei.avkjorsel("Kåre");

        System.out.println("Allfarvei:");
        for(Kjoretoy k : allfarvei) {
            System.out.println(k);
        }

        Vei<MotorisertKjoretoy> motorvei = new Vei<MotorisertKjoretoy>();
        motorvei.kjorInnPaaVei(buss);
        motorvei.kjorInnPaaVei(bil);
        motorvei.kjorInnPaaVei(bil2);

        System.out.println("\nMotorvei:");
        for(Kjoretoy k : motorvei) {
            System.out.println(k);
        }
    }
}