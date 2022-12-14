import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
     TASK :
     fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
   */
    /*
        /*
     Pojo(Plain Old Java Object) Class nedir
     1)Variable ları private olan (Encapsulation yapılmış olan)
     2)Bir parametresiz birde parametreli Constructor olan
     3)Getter ve Setter methodlar olan
     4)toString() methodu olan
      Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
     */


    public static void main(String[] args) {
        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul ","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilg muh",1080,77);
        Universite u05 = new Universite("odtu","gemi muh",333,74);

        List<Universite> unv=new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));
        System.out.println(notOrt74BykUnv(unv));//false
        System.out.println();
        System.out.println(matBolumVarMi(unv));//true
        System.out.println();
        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println();
        System.out.println(matBolumSayisi(unv));
        System.out.println();
        System.out.println(ogrcSayisi550BykMaxNotOrt(unv));//OptionalInt[93]
        System.out.println();
        System.out.println(ogrcSayisi1050AzMinNotOrt(unv));//OptionalInt[71]
    }
    //task 01--> Butun universitelerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv( List<Universite> unv){
        return unv.
                stream().//akis sagladik universiteler u01,u02,u03,u04,u05
                allMatch(t->t.getNotOrt()>74);//allmatch yukaridan gelen  butun akistaki sarti saglarsa true olacak
    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static  boolean matBolumVarMi(List<Universite> unv){
        return unv.
                stream().//akis saglandi
                anyMatch(t->t.getBolum().//objelerin bolum isimleri alindi anymatch=herhangi biri ifadesi
                        toLowerCase().//bolum isimlerindeki karakterler kucuk harfe cevrildi
                        contains("mat"));//mat kelimesi var mi kontrol
    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv){
         return unv.// List<Integer>--(1,2,3,4)//List<Intger>-->(u01,u02,u03,u04,u05)
                 stream().//akis saglandi
                 sorted(Comparator.comparing(Universite::getOgrSayisi).//universiteler ogrenci sayisina gore tersten siralandi
                         reversed()).
                collect(Collectors.toList());//stream yapisi list yapisina donusturuldu
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv){
         return (int )   unv.
                stream().//akis saglandi
                filter(t->t.getBolum().contains("mat")).//mat bolumu olan unv sectim
                count();//secilen unv sayisini aldim
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi550BykMaxNotOrt(List<Universite> unv){//OptionalInt neden bu method kullandik null pointer atmamasi icin
       return unv.
                stream().//
                filter(t->t.getOgrSayisi()>550).
                mapToInt(t->t.getNotOrt()).//maptoint de akis degisti universite yerine artik not ortalamasina bakacagiz
                max();//maptoint bu method sayesinde max methodunu kullandik

    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1050AzMinNotOrt(List<Universite> unv){
     return unv.
             stream().
             filter(t -> t.getNotOrt() < 1050).
             mapToInt(t -> t.getNotOrt()).
             min();
    }
}
