import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = null;
        int total = 0;
        try {
            reader = new BufferedReader(new FileReader("C:\\JavaDemos\\readingFileDemo\\src\\sayilar.txt"));
            String line = null;
            while ((line = reader.readLine())!=null){
              total += Integer.valueOf(line);//txt dosyasındaki değerler string olarak geliyor
                //dolayısıyla Integer.valueOf komutuyla bunu int değere çevirebiliyoruz.

            }
            System.out.println("Toplam = "+total);


        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
