public class Main {

    public static void main(String[] args) {
        String mesaj = "Bugün hava çok güzel";
        String yenimesaj = sehirVer();
        System.out.println(yenimesaj);
        int sayi = topla(15, 7);
        System.out.println(sayi);
        System.out.println(yenimesaj);
        int toplam = topla2(2, 3, 4, 5, 6, 7, 8, 10);
// arka planda diziye çevrildi topla2 methodu parametreleri.
    }

    public static void ekle() {
        System.out.println("Eklendi");
    }

    public static void sil() {
        System.out.println("Silindi");
    }

    public static void güncelle() {
        System.out.println("Güncellendi.");
    }

    public static int topla(int sayi1, int sayi2) {
        return sayi1 + sayi2;
    }

    public static String sehirVer() {
        return "Ankara";
    }

    public static int topla2(int... sayilar) {

        int toplam = 0;
        for (int sayi : sayilar) {
            toplam += sayi;
            return toplam;
      /*
void operasyon : Emir kipi gibi bir şeyi yap diyor.
fakat örn; eklediğim şeyi bana geri ver dendiğinde void değişmek zorunda
kalıyor. void olan operasyonları bir değişkene atayamayız.

 */

        }


    }


}



