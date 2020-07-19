class LenkelisteTest {
    public static void main(String[] args) {
        Lenkeliste<String> ll = new Lenkeliste<String>();
        ll.settInn("BBBB");
        ll.settInn("AAA");
        ll.settInn("CCC");
        System.out.println("Fjernet" + ll.fjernMinste());

        ll.skrivUt();
    }
}