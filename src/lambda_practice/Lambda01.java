package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        hepsiniYazdir(list);
        System.out.println();
        negatifYaz(list);
        System.out.println();
        ciftYaz(list);
        System.out.println();
        pozVeCift(list);
        System.out.println();
        pozVeyaCiftYaz(list);
        System.out.println();
        kareYazdir(list);
        System.out.println();
        ciftKupYazdir(list);
        System.out.println();
        kareTekrarsiz(list);
        System.out.println();
        elSirala(list);
        System.out.println();
        elTersSirala(list);
        System.out.println();
        System.out.println("pozKup5List(list) = " + pozKup5List(list));
        pozKup5List2(list);
        System.out.println("pozKareSon5DegilList(list) =" +pozKareSon5DegilList(list));
        System.out.println("elToplam()="+elToplam(list));
        System.out.println("elToplamReference(list)=" +elToplamReference(list));
        System.out.println("elToplamReferenceInt(list)=" +elToplamReferenceInt(list));
        pozElToplam(list);
    }

    //S2:listi aralarinda bosluk birakarak yazdiriniz

    public static void hepsiniYazdir(List<Integer>l){

        l.stream().forEach(t->System.out.print(t+ " "));
    }

    //S2:sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer>l){

        l.stream().filter(t->t<0).forEach(t->System.out.print(t+ " "));
    }

    //S3:sadece cift olanlari yeni bir liste olustur

    public static void ciftYaz(List<Integer>l){

        l.stream().filter(t->t%2==0).forEach(t->System.out.print(t+ " "));
    }

    //S4:pozitif ve  cift olanlari yeni bir liste olustur

    public static void pozVeCift(List<Integer>l){

        l.stream().filter(t->t%2==0 && t>0).forEach(t->System.out.print(t+ " "));
    }

    //S4:pozitif veya  cift olanlari yeni bir liste olustur
    public static void pozVeyaCiftYaz(List<Integer>l){

        l.stream().filter(t->t%2==0 || t>0).forEach(t->System.out.print(t+ " "));
    }
    // S6: list in elemanlarin karelerini ayn?? sat??rda b??r bosluklu yazd??ral??m

    //map():stream den gelen elemanlar?? baska tt??plere donusturmek veya uzerler??nde
    //??slem yapmak ??c??n (update) kullan??l??r

    public static void kareYazdir(List<Integer>l){
        l.stream().map(t->t*t).forEach(t->System.out.print(t+" "));
    }

    //S7: Listin cift elemanlar??n??n kuplerini  ayn?? sat??rda b??r bosluklu yazd??ral??m
    public static void ciftKupYazdir(List<Integer>l){
        l.stream().filter(t->t%2==0).map(t->t*t*t).forEach(t->System.out.print(t+" "));
    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazd??ral??m
    //distinct() methodu tekrarli elemanlari benzersiz hale getiriyor
    //distinct() => Bu method tekrarl?? elemanlar?? sadece bir kere ak??sa sokar.
    // Bu ak??????n farkl?? elemanlar??ndan (Object.equals (Object) 'e g??re) olu??an bir ak???? d??nd??r??r.
    // S??ral?? ak????lar i??in, farkl?? eleman??n se??imi sabittir
   // (yinelenen ????eler i??in, kar????la??ma s??ras??nda ilk g??r??nen ????e korunur.)
   // S??ras??z ak????lar i??in, herhangi bir kararl??l??k garantisi verilmez. Stream return eder.
    public static void kareTekrarsiz(List<Integer>l){
        l.stream().map(t->t*t).distinct().forEach(t->System.out.print(t+" "));
    }

    //S9: listin elemanlarini kucukten buyuge siralayalim
    //sort () siralamada kullanilir
    public static void elSirala(List<Integer>l){
        l.stream().sorted().forEach(t->System.out.print(t+" "));
    }
    //S10: listin elemanlarini  buyukten kucuge dogru siralayalim
    //sorted(Comparator.reverseOrder()) tersi sekilde siralar
    public static void elTersSirala(List<Integer>l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.print(t+" "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    // .collect(Collectors.toList()); ak????tan gelen elemanlar?? yeni bir listenin i??erisine yerle??tirir.
    public static List<Integer>pozKup5List(List<Integer>l){
       return l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
    }

    public static void pozKup5List2(List<Integer>l){
        List<Integer>list=l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
        System.out.println(list);
    }

    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> pozKareSon5DegilList(List<Integer>l){
        List<Integer>list=l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
        return list;
    }
    // S13 :list elemanlarini toplamini bulalim
    /*
    reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
    kullan??m?? yayg??nd??r pratiktir.
    Bir Stream i??erisindeki verilerin teker teker i??lenmesidir. Teker teker i??leme s??recinde, bir ??nceki ad??mda elde edilen sonu??
    bir sonraki ad??ma girdi olarak sunulmaktad??r. Bu sayede y??????lml?? bir hesaplama s??reci elde edilmi?? olmaktad??r.
   reduce metodu ilk parametrede identity de??eri, ikinci parametrede ise BinaryOperator t??r??nden bir obj kullan??l??r.
   reduce i??leminde bir ??nceki hesaplanm???? de??er ile s??radaki de??er bir i??leme tabi tutulmaktad??r.
   ????leme ba??larken bir ??nceki de??er olmad?????? i??in bu de??er identity parametresinde tan??mlanmaktad??r.
   */
    public static int elToplam(List<Integer>l){
        //x ilk degeri 0 sifirdir sonraki deger x+y dir y de siralamadan degeri aliyor
        /*
        * x ilk degerini her zaman atanan degerden (ilk parametre) al??r,
        bu ??rnekte 0 oluyor
        * y degerini her zamana  stream()'dan ak??sdan al??r
        * x ilk degerinden sonraki her de??eri action(i??lem)'dan al??r */
        int i=l.stream().reduce(0,(x,y)->x+y);
        return i;
    }

    public static int elToplamReference(List<Integer>l){

        int i=l.stream().reduce(0,Math::addExact);
        return i;
    }

    public static int elToplamReferenceInt(List<Integer>l){

        int i=l.stream().reduce(0,Integer::sum);
        return i;
    }

    //S14 : Listin pozitif elemanlar?? toplam??n?? bulal??m
    public static void pozElToplam(List<Integer>l){
       l.stream().filter(t->t>0).reduce(0,Integer::sum);

    }

}
