public class Ytre {
    private int tall;

    public Ytre() {
        tall = 2;
    }

    public void metode() {
        tall++;
    }

    public class Indre {
        private int tall;

        public Indre() {
            tall = 0;
        }

        public void indreMetode() {
            System.out.println("Tall:" + tall);
            System.out.println("this.tall:" + this.tall);
            System.out.println("Ytre.this.tall:" + Ytre.this.tall);
            //tall2++;
        }
    }
}