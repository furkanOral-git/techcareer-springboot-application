public class Main {

    public static void main(String[] args) {
        double[] myList = {1.2, 1.3, 1.4, 1.5};
        double total = 0;//***Önemli Not : bir değişkenin cinsini 1 kere tanımla sonrasında sadece adını kullanman yeterli.
        for (double number : myList) {
            System.out.println(number);
            total = total + number;

            //burada kullandığımız for döngüsünde "number", dizinin içinde gezecek değişken
            //önceki alıştırmada i yi 0 dan başlatıp dizi elamanı kadar adım adım yürütmüştük
            // bu şekil bir yazımla da number(i) değişkenini myList içinde yürütücez.
        }

        System.out.println("Total = " + total);
    }
}
