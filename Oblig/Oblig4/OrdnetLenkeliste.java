public class OrdnetLenkeliste<T extends Comparable<T>> extends Stabel<T>{
  private Node bak;

/*
- Et negativt tall hvis a er mindre enn b
- 0 hvis a er lik b
- Et positivt tall hvis a er større enn b
*/
  @Override
  public void settInn(T element){
    Node ny = new Node(element);
    antall++;
    if (erTom()){
      foran = ny; bak = ny;
    }

    else if(element.compareTo(foran.data) < 0){ // da skal den nye noden først
      ny.neste = foran;
      foran = ny;

    }
    else if (element.compareTo(bak.data) > 0){
      bak.neste = ny; //legger ny bakerst
      bak = ny; //for at bak skal peke på den bakerste noden
    }

    else{
      for(Node n = foran; n.neste != null ;n = n.neste) {//n.neste : skal gå til neste = null
        if(element.compareTo(n.neste.data)<0){
          ny.neste = n.neste;
          n.neste = ny;
          return; //må hoppe ut av løkken!
        }
      }
    }
  }

  @Override
  public T fjern(){
    if (erTom()) return null; // om den er tom
    T tmp = foran.data;
    foran = foran.neste;
    if (antall==1) bak = null; // om vi har 1 element
    antall--;
    return tmp;
  }

}
