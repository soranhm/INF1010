class TestEspressoMaskin{
  public static void main(String[] args) {
    //Oppretter EspressoMaskin
    EspressoMaskin em = new EspressoMaskin();

    //Sjekker om vannmengde er 0 ved start.
    System.out.println("Ved opprettelse er vannmengde " + em.hentVannmengde());

    //Prover aa lage en espresso
    System.out.println("Prover aa lage en espresso");
    em.lagEspresso();

    //Prover aa sette inn 500 ml
    System.out.println("Prover aa sette inn 500 ml");
    em.fyllVann(500);

    //Prover aa lage en lungo
    System.out.println("Prover aa lage en lungo");
    em.lagLungo();

    //Prover aa sette inn 1000 ml
    System.out.println("Prover aa sette inn 1000 ml");
    em.fyllVann(1000);
  }
}

class EspressoMaskin {
    private int maxBeholdningVanntank = 1000; //Vanntanken kan maksimalt romme 1000ml van.
    private int innholdVanntank = 0; //Vanntanken er tom ved start.

    // Lag espresso dersom det er nok vann(40 ml)
    public void lagEspresso() {
        if(innholdVanntank >= 40){
          innholdVanntank -= 40; //Bruker 40ml for aa lage espresso.
          System.out.println("Espresso ble laget. Innholdet i vanntanken er naa " + innholdVanntank);
        } else {
          System.out.println("Du har for lite vann for aa lage espresso. Innholdet i vanntanken er " + innholdVanntank);
        }
    }

    // Lag lungo dersom det er nok vann(100ml)
    public void lagLungo() {
      if(innholdVanntank >= 100){
        innholdVanntank -= 100; //Bruker 100ml for aa lage lungo.
        System.out.println("Lungo ble laget. Innholdet i vanntanken er naa " + innholdVanntank);
      } else {
        System.out.println("Du har for lite vann for aa lage lungo. Innholdet i vanntanken er " + innholdVanntank);
      }
    }

    // Fyll på et gitt antall milliliter vann, dersom det er plass
    public void fyllVann(int ml) {
      if(ml + innholdVanntank > maxBeholdningVanntank){
        System.out.println("Du prover aa sette inn for mye vann i vanntanken. Innholdet i vanntanken er " + innholdVanntank);
      } else {
        innholdVanntank += ml; //Oppdaterer innholdet i vanntanken
        System.out.println(ml + " ble satt inn i vanntanken. Innholdet i vanntanken er er " + innholdVanntank);
      }
    }

    // Les av maalestrekene på vanntanken og tilgjengelig vann i ml
    public int hentVannmengde() {
      return innholdVanntank;
    }
}
