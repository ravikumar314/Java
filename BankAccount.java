
class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message){
        super(message);
    }
}

public class BankAccount {
    
    private double balance = 1000;

    void withdraw(double amount) throws InsufficientBalanceException{

        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        try {
             account.withdraw(100);
             account.withdraw(1000);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }
}
