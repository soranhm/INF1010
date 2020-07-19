public class EqualsEksempel {
    public static void main(String[] args) {
        Hund hund1 = new Hund("Passopp", 12);
        Hund hund2 = new Hund("Passopp", 12);

        System.out.println(hund1.equals(hund2));
    }
}