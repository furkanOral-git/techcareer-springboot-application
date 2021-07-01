import matematik.Dortİslem;
import matematik.Logaritma;
import matematik.*;//Matematik pakedindeki tüm her şeyi import et.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adınız");
        String isim = scanner.nextLine();
        System.out.println("Merhaba " + isim);
        Dortİslem dortİslem = new Dortİslem();
        dortİslem.topla(2,5);
        Logaritma logaritma = new Logaritma();
    }
}
