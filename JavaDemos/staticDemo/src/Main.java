public class Main {

    public static void main(String[] args) {
	ProductManager productManager = new ProductManager();
	Product product = new Product();
	Product.price = 1000;
	Product.id = 12;
	Product.name ="mouse";
	productManager.add(product);
	DataBaseHelper.Crud.delete();
	DataBaseHelper.Connection.createConnection();


    }


}
//staticler bellekte çakılı yer tutar. bir class artı statik olan metodunu
// rahatlıkla çağırabilirsiniz. Newlemenize gerek yok çünkü new tek kullanımlıktır.
//refarans koduyla heap bellekteki nesne çağrılır, kullanılır ve nesne yok edilir.