public class Main {

    public static void main(String[] args) {

        int number = 5;
        int total = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                total += i;
            }
        }
        if (total == number) {
            System.out.println("Mükemmel Sayıdır.");
        } else {
            System.out.println("Mükemel sayı değildir.");
        }

    }
}
