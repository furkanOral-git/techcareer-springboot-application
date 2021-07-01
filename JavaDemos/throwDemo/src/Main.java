public class Main {

    public static void main(String[] args) throws Exception {
	AccountManager accountManager = new AccountManager();
	System.out.println("Hesap = "+accountManager.getBalance());
	accountManager.deposit(100);
	System.out.println("Hesap = "+accountManager.getBalance());
    try {
		accountManager.withdraw(120);
	}catch(Exception exception){
    	System.out.println(exception.getMessage());
	}

    System.out.println("Hesap = "+accountManager.getBalance());




    }
}
