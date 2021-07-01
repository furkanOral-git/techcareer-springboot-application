import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> sehirler = new ArrayList<String>();
        //<Elamanların tipi>
        sehirler.add("Ankara");
        sehirler.add("İstanbul");
        sehirler.add("Zonguldak");
        sehirler.add("İzmir");
        sehirler.add("Aydın");

        sehirler.remove("Zonguldak");
        Collections.sort(sehirler);

        for (String sehir:sehirler){
            System.out.println(sehir);
        }

    }
}
