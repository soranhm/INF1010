class EnumEksempel {
    private enum Ukedag {
        MANDAG,
        TIRSDAG,
        ONSDAG,
        TORSDAG,
        FREDAG,
        LORDAG,
        SONDAG
    }

    public static void main(String[] args) {
        infoOmUkedag(Ukedag.LORDAG);
    }

    public static void infoOmUkedag(Ukedag dag) {
        switch(dag) {
            case MANDAG:
                System.out.println("Mandager er ikke så digge");
                break;
            case LORDAG:
                System.out.println("Endelig helg");
                break;
            case SONDAG:
                System.out.println("Helgen var digg");
                break;
            default:
                System.out.println("Ukedager er egentlig greie de også");
                break;
        }

        /*if (dag == Ukedag.MANDAG) {
            System.out.println("Mandager er ikke så digge");
        }
        else if (dag == Ukedag.LORDAG) {
            System.out.println("Endelig helg");
        }*/
    }
}