public class Main {

    public static void main(String[] args) {

    }
    public static void sayiBulmaca(){
        int [] sayilar = new int[]{1,2,5,7,9,0};
        int aranacak = 5;
        boolean varMi =false;

        for (int sayi:sayilar){
            if (sayi ==aranacak){
                varMi=true;
                break;
            }
        }
        if (varMi){
            System.out.println("Sayı mevcuttur.");
        }else{
            System.out.println("Sayı mevcut değildir.");
        }
    }
    public static void mesajVer(int aranacak){//parametreli
        //metod(fonksiyon)
        System.out.println("Sayı mevcuttur: "+aranacak);

        //hiçbir şey değer vermeyen yani "return" etmeyen fonksiyonlar "VOİD" fonksiyonlardır.
// ingilizce çeviride Void anlaı : Geçersiz, Hükümsüz, Boş olarak geçiyor.
    }
}
