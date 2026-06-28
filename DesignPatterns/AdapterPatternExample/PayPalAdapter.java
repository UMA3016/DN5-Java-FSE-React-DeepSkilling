public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;

    // Accept the adaptee through the constructor
    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}
