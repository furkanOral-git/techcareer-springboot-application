public class AccountManager {
    private double balance;
    public void deposit(double amount){
        balance = getBalance() + amount;
    }
    public void withdraw(double amount)throws Exception{
        if (balance>=amount){
            balance = getBalance() - amount;

        }else {
            //System.out.println("Para çekilemedi bakiye yetersiz!!!");
            // bu hata mesajını şu şekilde veriyoruz.
            throw new Exception("Bakiye yetersiz!!!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
