import java.io.File;

public class FilTre {
    private String filbane;

    public FilTre(String filbane) {
        this.filbane = filbane;
    }

    private void visTre(File mappe, String prefiks) {
        File[] innhold = mappe.listFiles();

        for (File fil : innhold) {
            if (fil.isDirectory()) {
                System.out.println(prefiks + fil.getName() + "/");
                visTre(fil, prefiks + "  ");
            } else {
                System.out.println(prefiks + fil.getName());
            }
        }
    }

    public void visTre() {
        visTre(new File(filbane), "");
    }

    public static void main(String[] args) {
        FilTre filTre = new FilTre(System.getProperty("user.dir"));
        filTre.visTre();
    }
}




