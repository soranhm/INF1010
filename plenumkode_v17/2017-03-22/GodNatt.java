class EnkelListe {
    private Node forste;
    private Node siste;

    private class Node {
        String data;
        Node neste;

        public Node(String data) {
            this.data = data;
        }
    }

    public void settInnBak(String data) {
        Node nyNode = new Node(data);

        if (forste == null) {
            forste = siste = nyNode;
        }
        else {
            siste.neste = nyNode;
            siste = nyNode;
        }
    }

    public void skrivGodnatt() {
        System.out.println("Det var en gang en liten " + forste.data);
        skrivGodnatt(forste);
    }

    private void skrivGodnatt(Node node) {
        if (node.neste == null) {
            System.out.println("som sov så godt");
            return;
        }
        System.out.print("som ikke klarte å sove, så moren til " + node.data);
        System.out.println("en fortalte ham en historie om en liten " + node.neste.data);
        skrivGodnatt(node.neste);
        System.out.println("... og den lille " + node.data + "en sovnet");
    }
}
class GodNatt {
    public static void main(String[] args) {
        EnkelListe liste = new EnkelListe();
        liste.settInnBak("gutt");
        liste.settInnBak("katt");
        liste.settInnBak("bjørn");
        liste.settInnBak("panda");

        liste.skrivGodnatt();
    }
}
