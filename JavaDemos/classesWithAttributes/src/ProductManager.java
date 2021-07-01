public class ProductManager {
    public void add(Product product){

        //JDBC kodları ile veritabanına kaydediyor olacağız.
        System.out.println("Ürün eklendi."+ product.getName());
    }
}
