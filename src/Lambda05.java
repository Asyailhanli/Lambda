import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5));//15
        System.out.println(toplaCinCix(5));//15
        System.out.println(toplaCift(4));
        System.out.println(toplaIlkXCift(4));
        System.out.println(toplaIlkXTek(3));//9
        ikininIlkXKuvvetPrint(3);//2 4 8
        System.out.println();
        istenenSayiIlkXKuvvetPrint(3, 2);//3 9
        System.out.println();
        System.out.println(istenenSayiFactorialPrint(5));//120


    }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
    // tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam = toplam + i;
        }
        return toplam;
    }

    //Functional
    public static int toplaCinCix(int x) {//List<Integer> x
        return IntStream.//int degerlerde bir akis saglar .bize verilmeyen List<Integer> x bunu varmis gibi davraniyor
                range(1, x + 1).//range(a,b)--> a dan b'ye kadar(b dahil degil) int degerler akisa alindi
                sum();//akistan gelen degerler toplandi
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).//rangeClosed(1,X) her ikisi de dahil
                        filter(t -> t % 2 == 0).//(Lambda::ciftbul) da olabilir
                        sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaCiftIlk(int x) {//ogrenci cozumu
        return IntStream.
                rangeClosed(1, x * 2).
                filter(t -> t % 2 == 0).
                sum();
    }

    public static int toplaIlkXCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).//2 den sonsuza kadar elemanlari 2 artirarak akisa alir -->2,4,6,8....
                        limit(x).//x ile siniliyorum
                        sum();//akistan gelen butun degerleri topluyorum
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2).//1,3,5,7.....
                        limit(x).//ilk x tek tamsayi ile sinirlandirildi
                        sum();//akistan gelen int degerler toplandi
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.
                iterate(2, t -> t * 2).//iterasyon icin sartimizi yazdik 2,4,8,16,32
                limit(x).// x degeri sinirlandirildi
                forEach(Lambda01::yazdir);//Lambda01 classindaki yazdir() methodudunu cagirarak ekrana yazdik

    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    //5-->5*4*3*2*1
    public static int istenenSayiFactorialPrint(int x) {
        return IntStream.//int akis basladi
                rangeClosed(1, x).//rangeClosed(1,5) -->1,2,3,4,5
                        reduce(1, (t, u) -> t * u);//

    }
}