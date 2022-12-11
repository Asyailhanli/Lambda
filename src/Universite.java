public class Universite {

    private String university;
    private String bolum;
    private int ogrSayisi;
    private int notOrt;

    //parametresiz constructor
    public Universite() {
    }
   //parametreli const.
    public Universite(String university, String bolum, int ogrSayisi, int notOrt) {
        this.university = university;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    //GETTER SETTER
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    //toString
    @Override
    public String toString() {
        return "Universite{" +
                "university='" + university + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
