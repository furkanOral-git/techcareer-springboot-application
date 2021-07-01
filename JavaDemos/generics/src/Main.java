import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> sehirler = new ArrayList<String>();//Array list String ile çalışan
        //generic bir classdır.

        //tip güvenli çalışma için genericlere ihtiyaç duyarız.
        Mylist<Customer> listem = new Mylist<Customer>();
        listem.add(new Customer());
        listem.add(new Customer());

    }
}
