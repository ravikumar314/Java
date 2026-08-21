interface PaymentProcessor{
    void pay(double amount);
}


class UPIPayment implements PaymentProcessor{
    @Override
    public void pay(double amount){
        System.out.println("paying " + amount + " with UPI");
    }
}

class CreditCardPayment implements PaymentProcessor{
    @Override
    public void pay(double amount){
        System.out.println("paying " + amount + " with credit card");
    }
}

class PaymentService{

    public void ProcessPayment(PaymentProcessor processor, double amount){
        processor.pay(amount);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        
        PaymentProcessor upiProcessor = new UPIPayment();
        PaymentProcessor creditcardPayment = new CreditCardPayment();

        PaymentService paymentService = new PaymentService();
        paymentService.ProcessPayment(upiProcessor, 1000.15);
        paymentService.ProcessPayment(creditcardPayment, 20000);

    }
}
