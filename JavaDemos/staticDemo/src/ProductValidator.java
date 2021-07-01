public class ProductValidator {
    public static boolean isValid(Product product) {
        if (Product.price > 0 && !Product.name.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
