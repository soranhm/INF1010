class VriAatter {
    private Spiller[] spillere;
    private Kortbunke trekkbunke;
    private Kortbunke kortPaaBordet;
    private static final int antallKortFraStart = 7;

    private VriAatter(Spiller[] spillere, Kortbunke trekkbunke) {
        this.spillere = spillere;
        this.trekkbunke = trekkbunke;
        kortPaaBordet = new Kortbunke();
    }

    public static VriAatter nyttSpill() {
        Kortbunke trekkbunke = Kortbunke.helKortstokk();
        trekkbunke.stokk();

        int antallSpillere = IO.intFraBruker("Hvor mange skal spille? ");
        Spiller[] spillere = new Spiller[antallSpillere];
        for (int i = 0; i < antallSpillere; i++) {
            String melding = String.format("Skriv inn navn på spiller %d: ",
                                           i+1);
            String navn = IO.ikketomStringFraBruker(melding);
            Kortbunke haand = new Kortbunke();
            for (int j = 0; j < antallKortFraStart; j++) {
                Kort trukketKort = trekkbunke.fjernOeverste();
                haand.leggTil(trukketKort);
            }
            spillere[i] = new Spiller(navn, haand);
        }
        return new VriAatter(spillere, trekkbunke);
    }

    public void spill() {
        boolean spilletErOver = false;
        // legger et kort fra trekkbunken på bordet
        kortPaaBordet.leggTilOeverst(trekkbunke.fjernOeverste());

        while (!spilletErOver) {
            for (Spiller spiller : spillere) {
                System.out.printf("\nDEBUG: Trekkbunke: %d. Paa bordet: %d\n",
                                  trekkbunke.antallKort(),
                                  kortPaaBordet.antallKort());
                System.out.printf("\n\n%s sin tur. Paa bordet: %s\n",
                                  spiller.hentNavn(),
                                  kortPaaBordet.hentOeverste());
                Kort valgtKort = spiller.velgKort();
                int kortTrukket = 0;
                while (!gyldigTrekk(valgtKort)) {
                    if (valgtKort == null) {
                        // spilleren har ikke valgt noe kort
                        if (kortTrukket < 3) {
                            sikreAtTrekkbunkenIkkeErTom();
                            System.out.printf("\n%s trekker et kort.\n",
                                              spiller.hentNavn());
                            kortTrukket++;
                            Kort trukketKort = trekkbunke.fjernOeverste();
                            spiller.mottaKort(trukketKort);
                        } else {
                            System.out.printf("\n%s må melde pass.",
                                              spiller.hentNavn());
                            break;
                        }
                    } else {
                        System.out.println("\nUgyldig trekk!");
                    }
                    System.out.printf("Paa bordet: %s\n",
                                      kortPaaBordet.hentOeverste());
                    valgtKort = spiller.velgKort();

                }
                if (valgtKort != null) {
                    // spilleren har valgt et kort aa legge ut
                    // fjern kortet fra spillerens haand
                    spiller.fjernKort(valgtKort);
                    if (valgtKort.hentVerdi() == 8) {
                        System.out.println();

                        // bytt valgt kort med en 8-er i riktig farge
                        valgtKort = vri();
                        System.out.printf("%s vrir til %s\n",
                                          spiller.hentNavn(),
                                          valgtKort.hentFarge());
                    } else {
                        System.out.printf("%s legger ut %s\n",
                                          spiller.hentNavn(),
                                          valgtKort);
                    }

                    // legg ut kortet
                    kortPaaBordet.leggTilOeverst(valgtKort);
                    if (spiller.antallKortPaaHaanden() == 0) {
                        System.out.printf("%s vant!\n", spiller.hentNavn());
                        spilletErOver = true;
                        break;
                    }
                }
            }
        }
    }

    private boolean gyldigTrekk(Kort kort) {
        if (kort == null) {
            return false;
        }

        Kort oeverste = kortPaaBordet.hentOeverste();

        boolean sammeVerdi = kort.hentVerdi() == oeverste.hentVerdi();
        boolean sammeFarge = kort.hentFarge() == oeverste.hentFarge();
        boolean erAatte = kort.hentVerdi() == 8;
        return sammeVerdi || sammeFarge || erAatte;
    }

    private Kort vri() {
        String melding = "";
        int teller = 1;
        for (char farge : Kort.farger) {
            melding += String.format("[%d] %s\n", teller++, farge);
        }
        melding += "Velg en farge å vri til: ";
        int fargeIndeks = IO.intFraBrukerFomTom(melding, 1, 4);
        return new Kort(Kort.farger[fargeIndeks-1], 8);
    }

    private void sikreAtTrekkbunkenIkkeErTom() {
        if (!trekkbunke.erTom()) {
            return;
        } else {
            System.out.println("Stokker inn kort fra bordet i trekkbunke");
            // legg inn kort fra paaBordet og stokk
            Kort oeverste = kortPaaBordet.fjernOeverste();
            while (!kortPaaBordet.erTom()) {
                Kort kort = kortPaaBordet.fjernOeverste();
                trekkbunke.leggTil(kort);
            }
            trekkbunke.stokk();

            // legg tilbake det øverste kortet paa bordet
            kortPaaBordet.leggTil(oeverste);
        }
    }

    public static void main(String[] args) {
        VriAatter vriaatter = VriAatter.nyttSpill();
        System.out.println("Nytt spill opprettet");
        vriaatter.spill();
    }
}
