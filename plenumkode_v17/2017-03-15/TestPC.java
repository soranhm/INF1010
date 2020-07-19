public class TestPC {
    public static void main(String[] args) {
        PC pc1 = new PC("Dell");
        PC pc2 = new PC("MSI");
        PC pc3 = new PC("Alienware");

        System.out.println(pc3.serienummer);
        System.out.println(PC.hentSeriehittil());

        PC.Inni i = new PC.Inni(10);
        PC.Inni j = new PC.Inni(23);
    }
}