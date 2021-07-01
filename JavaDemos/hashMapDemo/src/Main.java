import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	//Dictionary = hashmap
        HashMap<String,String> sozluk = new HashMap<String,String>();
        sozluk.put("book","kitap");
        sozluk.put("table","masa");
        sozluk.put("pencil","kalem");
        sozluk.put("apple","elma");
        System.out.println(sozluk);
        System.out.println(sozluk.get("table"));
        for (String key: sozluk.keySet()){
            System.out.println(key);
            System.out.println("Key = "+ key + " ,Değer = "+sozluk.get(key));
        }


    }
}
