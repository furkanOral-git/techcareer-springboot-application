public class Validator <T>{
    public <T> void validate(T entity){
Validator validator = new Validator();
Customer customer = new Customer();
validator.validate(customer);
    }
}
