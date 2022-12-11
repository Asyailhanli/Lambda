import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi=new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);//16 4 36
        System.out.println();
        tekKupBirFazlaPrint(sayi);//1332 -124 344 28 3376
        System.out.println();
        ciftElKarekokPrint(sayi);
        System.out.println();
        maxElBul(sayi);//Optional[15]
        System.out.println();
        structuredMaxElBul(sayi);//en buyuk sayi :15
        System.out.println();
       ciftKareMaxPrint(sayi);//Optional[36]
        System.out.println();
        elTopla(sayi);//43
        System.out.println();
        ciftCarp(sayi);//Optional[48]
        System.out.println();
        minBul(sayi);//Optional[-5]
        System.out.println();
        bestenBykTekKck(sayi);//Optional[7]
        System.out.println();
        ciftKareKbSortPrint(sayi);//4 16 36

    }
    //TAASK-1: Functional Programming ile listin cift elemanlarinin karelerini
    //ayni satirda aralarina bosluk birakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().//akis saglandi
                filter(Lambda01::ciftBul).//akistaki cift sayilari filtreledim 4,2,6
                map(t->t*t).//16,4,36 yeni yapi eski yapi degisti.map() --> stream icerisindeki elemanlari baska degerlere donusturur
                forEach(Lambda01::yazdir);
    }
    //TASK 2:Functional Programming ile listin tek elemanlarinin kuplerinin bir fazlasini ayni satirda
    //aralarinda bosluk birakarak print ediniz
    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().//(4,2,6,11,-5,7,3,15)
                filter(t->t%2!=0).//11,-5,7,3,15
                map(t->(t*t*t)+1).//1332 -124 344 28 3376
                forEach(Lambda01::yazdir);
    }
    //TASK 3:Functional Programming ile listin cift elemanlarinin
    //karekoklerinin ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftElKarekokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//double old icin Lambda01::yazdir kullanamayiz
                //forEach(System.out::print);
                forEach(t-> System.out.print(t+" "));
    }
    //TASK 4: List'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi){
       Optional<Integer> maxSayi= sayi.
                                  stream().
                                  reduce(Math::max);//eger benim result'im tek bir deger ise o zaman reduce terminal opr.kullanilir
        System.out.println(maxSayi);
    }
    //Structured yapi ile cozelim
    public static void structuredMaxElBul(List<Integer> sayi){
        int max =Integer.MIN_VALUE;
        System.out.println("max = " + max);//
        for(int i=0 ; i<sayi.size(); i++){
            if(sayi.get(i)>max) max=sayi.get(i);
        }
        System.out.println("en buyuk sayi :" + max);
    }
    //TASK 5:List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));//Integer:: max, Math:: max, gore daha hizli calisir
    /*  Optional<Integer> x=sayi.
                         stream().
                         filter(Lambda01::ciftBul).
                         map(a -> a * a).
                         reduce(Integer::max);//Integer:: max, Math:: max, gore daha hizli calisir

     */

    }

    //TASK 6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda expression

    public static void elTopla(List<Integer> sayi){
//        int toplam=sayi.//4,2,6,11,-5,7,3,15
//                stream().
//                reduce(0,(a,b)->a+b);
//        System.out.println("toplam = " + toplam);
        System.out.println(sayi.//4,2,6,11,-5,7,3,15
                stream().
                reduce(0, (a, b) -> a + b));


        /*
           *a ilk degerini her zaman atanan degerden (ilk parametre)alir,
            bu ornekte 0 oluyor
           * b degerini her zaman stream()'dan akisdan alir
           * a ilk degerinden sonraki her degeri action(islem)'dan alir
         */
    }

    //TASK 7:List'teki cift elemanlarin carpimini yazdiriniz
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));//method referance

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b));//lambda expression optional olmasini istemiyorsak bunu kullanabiliriz
    }
    //TASK 8: List'teki elemanlardan en kucugunu print ediniz
    public static void minBul(List<Integer> sayi){
        //1.yol:method referance
        System.out.println(sayi.
                stream().
                reduce(Integer::min));//Math::min

        //2.yol:method referance
        System.out.println(sayi.
                stream().//(4,2,6,11,-5,7,3,15)
                reduce(Lambda02::byMiracMin));
    }
    public static int byMiracMin(int a,int b){//kendimiz method olusturduk
        return (a<b) ? a : b;//byMiracMin(4,9)
    }
    //TASK 9: List'teki 5 'ten buyuk en kucuk tek sayiyi print ediniz
    public static void bestenBykTekKck(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::byMiracMin));
    }
    //TASK 10: List'in cift elemanlarinin karelerini kucukten buyuge print ediniz
    public static void ciftKareKbSortPrint(List<Integer> sayi){
        sayi.
                stream().//akis baslattik
                filter(Lambda01::ciftBul).//akis icindeki cift sayilari aldim
                map(t->t*t).//sayilarin karesi ile yeni bir akis olsuturdum
                sorted().//akis icindeki sayilari natural-order olarak siraladim
                forEach(Lambda01::yazdir);//akisdaki sayilari ekrana yazdim
    }

}
