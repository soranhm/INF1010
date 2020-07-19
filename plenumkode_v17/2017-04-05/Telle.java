public class Telle {
    public static void main(String[] args) {
        int maks = args.length == 0 ? 10 : Integer.parseInt(args[0]);
        telle(0, maks, "");
    }
    public static void telle(int gjeldende, int maks, String prefiks) {
        if(gjeldende == maks) {
            System.out.println(prefiks + "Basistilfelle");
            return;
        }
        System.out.println(prefiks + gjeldende);
        telle(gjeldende + 1, maks, prefiks + " ");
        System.out.println(prefiks + gjeldende);
    }
}