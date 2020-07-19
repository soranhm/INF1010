
class Prosessor {

  // lager varibalene som blir brukt i denne klassen
  private int kjerne;
  private double klokke;

  // lager en konstroktor som tar imot int og double
  public Prosessor (int k, double kl) {
    kjerne = k; klokke = kl;
  }

  // lager et get konstroktor som returnere en del av Flopsen
  public double getFlops() {
    return kjerne * klokke * Math.pow(10,9)*8.0;
 }
}
