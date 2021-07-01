import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList sayilar = new ArrayList();
        System.out.println(sayilar.size());
        sayilar.add(1);
        sayilar.add(2);
        sayilar.add("Ankara");
        System.out.println(sayilar.size());
        System.out.println(sayilar.get(2));
        sayilar.set(0,100);
        System.out.println(sayilar.get(0));
        for (Object i:sayilar){
            System.out.println(i);
            //Object her türlü cinsten elamanı temsil ediyor
            //int yazsaydık eğer hata alıcaktık çünkü "Ankara"
            //String bir değer.
        }
    }
}
