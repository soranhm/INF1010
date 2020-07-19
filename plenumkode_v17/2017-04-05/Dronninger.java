public class Dronninger {
    private Felt[][] brett;
    private final int storrelse;
    private int antallLosninger = 0;

    public static void main(String[] args) {
        new Dronninger(8); // Prov gjerne aa endre til et annet tall!
    }

    public Dronninger(int storrelse) {
        this.storrelse = storrelse;
        this.brett = new Felt[storrelse][storrelse];

        for(int rad = 0; rad < storrelse; rad++) {
            for(int kol = 0; kol < storrelse; kol++) {
                brett[rad][kol] = new Felt();
            }
        }

        //loes(0); // Finner en losning
        //printBrett();
        loesAlle(0); // Finner alle losninger
        System.out.println("Antall losninger: " + antallLosninger);
    }

    public boolean loes(int kolonne) {
        if (kolonne == storrelse) {
            return true;
        }

        for(int rad = 0; rad < storrelse; rad++) {
            if(passer(rad, kolonne)) {
                brett[rad][kolonne].tatt = true;

                if (loes(kolonne+1)) {
                    return true;
                }

                brett[rad][kolonne].tatt = false;
            }
        }

        return false;
    }

    public void loesAlle(int kolonne) {
        if(kolonne == storrelse) {
            printBrett();
            System.out.println();
            antallLosninger++;
            return;
        }

        for(int rad = 0; rad < storrelse; rad++) {
            if(passer(rad, kolonne)) {
                brett[rad][kolonne].tatt = true;

                loesAlle(kolonne+1);

                brett[rad][kolonne].tatt = false;
            }
        }
    }

    private boolean passer(int rad, int kol) {
		for(int y = 0; y < storrelse; y++) {
			if(brett[rad][y].tatt) {
				return false;
			}
		}

		for(int y = Math.max(rad-kol, 0), x = Math.max(kol-rad, 0); y < storrelse && x < storrelse; y++, x++) {
			if(brett[y][x].tatt) {
				return false;
			}
		}

		int speilrad = (storrelse-1)-rad;
		for(int y = Math.max(speilrad-kol, 0), x = Math.max(kol-speilrad, 0); y < storrelse && x < storrelse; y++, x++) {
			if(brett[(storrelse-1)-y][x].tatt) {
				return false;
			}
		}

		return true;
	}

    public void printBrett() {
        for(int rad = 0; rad < storrelse; rad++) {
            for(int kol = 0; kol < storrelse; kol++) {
                String tegn = brett[rad][kol].tatt ? "Q" : "-";
                System.out.print(tegn + " ");
            }
            System.out.println();
        }
    }

    private class Felt {
        public boolean tatt = false;
    }
}