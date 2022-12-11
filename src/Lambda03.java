import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu= new ArrayList<>(Arrays.asList("trilece","havucDilim","guvec","kokorec","kusleme","arabAsi",
                                                   "waffle","kunefe","guvec"));
        alfBykTekrarsiz(menu);
        System.out.println();
        chrSayisiTersSiraliUnique(menu);
        System.out.println();
        chrSayisiBykSirali(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        System.out.println();
        wIleBaslayanElKontrol(menu);
        System.out.println();
        xIleBitenElKontrol(menu);
        System.out.println();
        charSayisiEnBykElPrint(menu);
        System.out.println();
        ilElHrcSonHrfSiraliPrint(menu);


    }

    // Task -1 : List elemanlarini alfabetik buyuk harf ve  tekrarsiz print ediniz.
     public static void alfBykTekrarsiz(List<String> yemek){
        yemek.
                stream().//akis basladi
                map(String::toUpperCase).//buyuk harf
                sorted().//dogal siralandi (alfabetik)
                distinct().//elemanlarin tekrarsiz olmasini sagladi
                forEach(t-> System.out.print(t +" "));
     }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSiraliUnique(List<String> ikram){
        ikram.
                stream().//akis alindi
                map(String::length).//akisi guncelledim, kelimelerin uzunlugu olarak// iki nokta ust uste yazilan hazir methodu cagiriyor
                sorted(Comparator.reverseOrder()).//ters sirali
                distinct().//tekrarsiz
                forEach(Lambda01::yazdir);//print
    }
    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    //note:.class icinde method cagirir :: ise baska classdayken cagirmaya yarar

    public static void chrSayisiBykSirali(List<String> ikram){
        ikram.
                stream().//akis saglandi
                sorted(Comparator.comparing(String::length)).//print ifadeleri karakter sayisina gore kucukten buyuge gore siraladim
                //forEach(t-> System.out.println(t+" "));//print
                forEach(Lambda01::yazdir);//yazdir methoduna gidip string method yazdim ve cagirdim
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemanlarinin hepsinin  karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> ikram){
        System.out.println(ikram.stream().
                allMatch(t->t.length()<=7)? "list elemanlari 7 ve daha az harften olusuyor":
                "list elemanlari 7 harften buyuk");

    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                noneMatch(t->t.startsWith("w")) ? "w ile yemek ismi mi olur":
                "w ile yemek icat ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı  var mi kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "masallah" : "x le yemek ismi biter mi hic");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.bak yazmadi
    public static void charSayisiEnBykElPrint(List<String> ikram){

      Stream<String> sonIsim = ikram.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()).//karakterse sayisina gore tersten siralandi
                limit(1);//limit methodu kullanilarak sadece ilk eleman cagrilir
            //limit ()--> methodunun donen degeri Stream<String> yapidadir

        System.out.println(Arrays.toString(sonIsim.toArray()));
        //sonIsim.toArray() -->stream olan akis array 'e cevirildi
        //Arrays.toString(sonIsim.toArray() -->array i string yapiya ceviriyor

    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilElHrcSonHrfSiraliPrint(List<String> ikram){
        ikram.
                stream().//akis saglandi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfine gore alfabetik siralandi
                skip(1).//akistaki ilk eleman haric tutuldu
                forEach(Lambda01::yazdir);//print

    }
}
