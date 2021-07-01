import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String mesaj = "Bugün hava çok güzel";
        System.out.println(mesaj);

        System.out.println("Eleman Sayısı: " + mesaj.length());//mesajın uzunluğu
        System.out.println(" 5. Eleman : " + mesaj.charAt(4));//mesajın içinde indexdekini bulma #charAt
        System.out.println(mesaj.startsWith("B"));//#startsWith başlıyor mu sorusunu sorar, false ya da true döndürür.
        System.out.println(mesaj.concat(" Yaşasın!"));//mesaja ekleme yapar fakat güncellemez!!#concat
        System.out.println(mesaj.endsWith("l"));// bu da l ile bitiyor mu demek.
        char[] karakterler = new char [5];

        mesaj.getChars(0,5,karakterler,0); //bir string içindeki karakterleri başka bir char arraye atmayı sağlar.
        System.out.println(karakterler);
        System.out.println(mesaj.indexOf("a"));//kaçıncı indexte onu bulmaya yarar. ilk bulduğunu verir ve bitirir.
        System.out.println(mesaj.lastIndexOf("a"));// aramaya en sağdan başlıyor yani cümlenin sonundan

        System.out.println(mesaj.replace(" ","-"));//yer değiştirme işlemi.
        System.out.println(mesaj.substring(2,5));//2 ile 5 i almıyor içerdekileri alıyor.System.out.println(mesaj.split(" "));

        for (String kelime : mesaj.split(" ")){
            System.out.println(kelime);
        }
        System.out.println(mesaj.toLowerCase());// hepsini küçük harf yapma
        System.out.println(mesaj.toUpperCase());//hepsini büyük harf yapma

         System.out.println(mesaj.trim());// başındaki ve sonundaki boşlukları atmaya yarar.


    }
}
