public class Bil extends MotorisertKjoretoy{
  public Bil(String regNr){
    super(regNr);
  }

  @Override
  public String toString(){
    return "Bil. " + super.toString();
  }
}
