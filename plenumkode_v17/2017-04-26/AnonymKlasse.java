class AnonymKlasse {
    interface NavneHilsen {
        void siHei(String navn);
    }

    class Hilsen implements NavneHilsen {
        void siHei() {
            System.out.println("Hello world");
        }

        @Override
        public void siHei(String navn) {
            System.out.println("Hello " + navn);
        }
    }

    public static void main(String[] args) {
        NavneHilsen hei = new NavneHilsen() {
            @Override
            public void siHei(String navn) {
                System.out.println("Heisann " + navn);
            }

            public void siHadet(String navn) {
                System.out.println("Hadet " + navn);
            }
        };
        hei.siHei("Bjarte Stine");
    }
}

// Eksempel på vanlig bruk av anonym klasse
/*class IterableKlasse implements Iterable<TypeNavn> {
    public Iterator<TypeNavn> iterator() {
        return new Iterator() {
            ...
        };
    }
}*/