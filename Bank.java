// Encapsulation is a fundamental concept in object-oriented programming that involves bundling the data (attributes) 
// and methods (functions) that operate on the data into a single unit, typically a class. It also restricts direct 
// access to some of the object's components, which can prevent the accidental modification of data.

class BankAccount {
    
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    double getBalance(){
        return this.balance;
    }

    String deposit(String account, double amount){

        if(accountNumber != account || amount < 0)
                return "failed to deposit";

        this.balance += amount;

        return "Deposit successful for account: " + account + "\nUpdated Balance is " + this.balance;

    }
}

public class Bank{
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 20000);

        System.out.println(account.getBalance());
        String status = account.deposit("12345", 1000);
        System.out.println(status);
        //System.out.println(account.getBalance());
        //System.out.println(account.balance);
    }
}