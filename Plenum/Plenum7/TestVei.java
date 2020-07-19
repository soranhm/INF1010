public class TestVei{
  public static void main(String[] args) {
    Vei<Kjoretoy> allfarvei = new Vei<Kjoretoy>();
    Buss buss = new Buss("BU1234");
    Bil bil = new Bil("BI1234");
    Sykkel sykkel = new Sykkel("Kåre");
    Bil bil2 = new Bil("AA123");

    allfarvei.kjorInnyPaaVei(buss);
    allfarvei.kjorInnyPaaVei(bil);
    allfarvei.kjorInnyPaaVei(sykkel);
    allfarvei.kjorInnyPaaVei(bil2);

    allfarvei.avkjorsel("Kåre");
    System.out.println("Allfarvei");
    for(Kjoretoy k: allfarvei){
      System.out.println(k);
    }

    Vei<MotorisertKjoretoy> motorvei = new Vei<MotorisertKjoretoy>();
    motorvei.kjorInnyPaaVei(buss);
    motorvei.kjorInnyPaaVei(bil);
    //motorvei.kjorInnyPaaVei(sykkel); // ikke en del av MotorisertKjoretoy
    motorvei.kjorInnyPaaVei(bil2);

    System.out.println("\nMotorvei");
    for(Kjoretoy k: motorvei){System.out.println(k);}

  }
}
