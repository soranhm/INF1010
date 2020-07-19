public class Lenkeliste<T> {
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

    // For-versjon av skrivUt()
    public void skrivUt2() {
        for(Node gjeldende = foran; gjeldende != null; gjeldende = gjeldende.neste) {
            System.out.println(gjeldende.data);
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




    private class Node {
        T data;
        Node neste;

        public Node(T data){
            this.data = data;
        }
    }


}
