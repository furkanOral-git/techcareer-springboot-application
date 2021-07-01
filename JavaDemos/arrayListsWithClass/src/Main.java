import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(new Customer(1,"Furkan","Oral"));
        customers.add(new Customer(2,"Elifnur","Oral"));
        customers.add(new Customer(3,"Talha","Oral"));

        for (Customer customer:customers){
            System.out.println(customer.firstName);
        }
    }
}
