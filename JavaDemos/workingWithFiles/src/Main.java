import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

getFileİnfo();
readFile();
writeFile();
readFile();
//ana blok


    }

    public static void createFile() {
        File file = new File("C:\\JavaDemos\\files\\students.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Dosya oluşturuldu.");
            } else {
                System.out.println("Dosya zaten mevcut.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileİnfo() {
        File file = new File("C:\\JavaDemos\\files\\students.txt");
        if (file.exists()){
            System.out.println("Dosya Adı: "+ file.getName());
            System.out.println("Dosya Yolu: "+ file.getPath());

        }
    }
    public static void readFile(){
        File file = new File("C:\\javaDemos\\files\\students.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
    public static  void writeFile(){
        try {
            FileWriter writer = new FileWriter("C:\\javaDemos\\files\\students.txt",true);
            writer.write("Ahmet");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


