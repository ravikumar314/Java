// use minorAmount ----> like 10.25 to 1025 (double , float are not precise for decimal conversion)
// use MajorAmount ----> 10.25
interface Payment{
    void pay(double amount);
}

class CreditCardPayment implements Payment{

    private String cardNumber;

    CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " through credit card " + cardNumber);
    }
}

class PaypalPayment implements Payment{

    private String email;
    
    PaypalPayment(String email){
        this.email = email;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " through paypal " + email + " account");
    }

}

public class Abstraction {
    public static void main(String[] args) {
        
        Payment cardPayment = new CreditCardPayment("12345678");
        cardPayment.pay(1000);

        Payment payPalPayment = new PaypalPayment("ravi314cs@gmail.com");
        payPalPayment.pay(1000.0);

    }
}
