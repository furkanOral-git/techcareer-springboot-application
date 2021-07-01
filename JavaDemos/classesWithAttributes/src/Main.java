public class Main {

    public static void main(String[] args) {
Product product = new Product();//kızmasının nedeni constructor methodu kullanmamız.
product.setName("Laptop");
product.setDesription("Msi");
product.setPrice(5000);
product.setStockAmount(100);
ProductManager productManager = new ProductManager();
productManager.add(product);

    }
}
