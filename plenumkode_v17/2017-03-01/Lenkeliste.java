public class Lenkeliste<T extends Comparable<T>> {
    private Node foran = null;

    public void settInn(T verdi) {
        Node nyNode = new Node(verdi);
        nyNode.neste = foran;
        foran = nyNode;
    }

    public void skrivUt() {
        Node gjeldende = foran;

        while(gjeldende != null) {
            System.out.println(gjeldende.data);
            gjeldende = gjeldende.neste;
        }
    }

    public boolean inneholder(T denne){
        Node temp = foran;

        while(temp != null){
            if (temp.data.toString().equals(denne.toString())){
                System.out.println("Lenkelisten inneholder " + denne);
                return true;
            }
            temp = temp.neste;
        }
        System.out.println("Lenkelisten inneholder ikke "+ denne);
        return false;
    }

    public int hentAntall(){
        int antall = 0;
        Node temp = foran;
        while(temp != null){
            antall++;
            temp = temp.neste;
        }
        return antall;
    }

    public boolean erTom(){
        if(foran == null){
            return true;
        } else {
            return false;
        }
        //return foran == null;
    }

    public T fjernMinste() {
        if (erTom()) {
            throw new RuntimeException("Kan ikke fjerne fra tom liste");
        }

        Node temp = foran;
        Node forrige = null;
        Node minst = foran;

        while(temp != null) {
            if (temp.neste != null && temp.neste.data.compareTo(minst.data) <= 0) {
                minst = temp.neste;
                forrige = temp;
            }
            temp = temp.neste;
        }

        if (minst == foran) {
            foran = foran.neste;
        }
        else {
            forrige.neste = minst.neste;
        }
        return minst.data;
    }


    private class Node {
        T data;
        Node neste;

        public Node(T data){
            this.data = data;
        }
    }


}