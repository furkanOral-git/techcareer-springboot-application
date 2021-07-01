public class Product {

   public Product (int id, String name, String description, double price,String renk){
      System.out.println("Yapıcı blok çalıştı");
      this.id = id;
      this.renk = renk;
      this.name = name;
      this.stockAmount = stockAmount;
      this.price = price;
      this.desription = description;
      this.kod = kod;
   }
//overloading aynı methodla fakat farklı parametrelerle çalışma.
   // attribute ya da field denir.
   private int id;
   private String name;
   private String desription;
   private double price;
   private int stockAmount;
   private String renk;
   private String kod;

//getter
   public int getId() {
      return id;
   }
//setter
   public void setId(int id) {
      this.id = id;//this kavramı parametre olarak verilen sınıf elanamanıyla
      //karışmaması için verilir.
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDesription() {
      return desription;
   }

   public void setDesription(String desription) {
      this.desription = desription;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public int getStockAmount() {
      return stockAmount;
   }

   public void setStockAmount(int stockAmount) {
      this.stockAmount = stockAmount;
   }

   public String getRenk() {
      return renk;
   }

   public void setRenk(String renk) {
      this.renk = renk;
   }

   public String getKod() {
      return kod;
   }

   public void setKod(String kod) {
      this.kod = kod;
   }
}
