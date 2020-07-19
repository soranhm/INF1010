class Legeliste extends OrdnetLenkeliste<Lege> {

    public Lege finnLege(String navn) {
      for (Lege l : this) {
        if (l.hentNavn().equalsIgnoreCase(navn)) {
          return l;
        }
      }
      return null;
    }

    public String[] stringArrayMedNavn() {
        String[] l = new String[this.storrelse()];
        int i = 0;
        for (Lege lege: this){
          l[i] = lege.hentNavn();
          i++;
        }
        return l;
    }
}
