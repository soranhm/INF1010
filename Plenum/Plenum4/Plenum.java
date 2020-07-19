public class Plenum {
    public static void main(String[] args) {
        Katt pus = new Katt("Pus", 1);

        Husdyr bjarte = new Hund("Bjarte", 2);
        bjarte.oppdaterAlder(10);

        Husdyr[] beholder = new Husdyr[3];
        beholder[0] = pus;
        beholder[1] = bjarte;
        beholder[2] = new Hund("Stine", 4);

        for(int i = 0; i < beholder.length; i++) {
            System.out.println(beholder[i]);
            /*
            if (beholder[i] instanceof Hund) {
                //Hund hund = (Hund) beholder[i];
                //hund.bjeff();
                ((Hund)beholder[i]).bjeff();
            }

            else if (beholder[i] instanceof Katt) {
              //Katt katt = (Katt) beholder[i];
              //katt.mjau();
              ((Katt)beholder[i]).mjau();
            }
        */
        // Dette er bedre måte å gjøre ovenstående på

        beholder[i].lagLyd();
    }
  }
}
