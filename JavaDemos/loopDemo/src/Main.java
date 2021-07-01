public class Main {

    public static void main(String[] args) {
        //for döngüsü
        for (int i = 1; i <= 10; i += 2) {
            System.out.println(i);

            //;den önceki ilk alan(i=1)sayacın nerden başlayacağını gösterir
            //i<=10 şart bloğudur nereye kadar döngünün devam edeceğine karar verir.
            //i++ i nin ilk değerinin son değerine kadar hangi işlemle yürüyeceğini belirler.
            //i++ = i+1 demektir.** , i+= 2şer arttır demektir.**
            //for döngüsünün altında verdiğimiz ise yürüyüşün her  adımında yapacağı işlemdir.
        }
        System.out.println("For döngüsü bitti");
        //while döngüsü
        int i = 1;
        while (i < 10) {
            System.out.println(i);
            i += 2;

        }
        System.out.println("While Döngüsü bitti");
        //Do While döngüsü
        int j = 1;
        do {
            System.out.println(j);
            j += 2;
        } while (j < 10);
        System.out.println("Do while döngüsü bitti.");
        //do-while döngüsünde şart sağlanmasa bile bir kere çalışacaktır döngü.

    }
}
