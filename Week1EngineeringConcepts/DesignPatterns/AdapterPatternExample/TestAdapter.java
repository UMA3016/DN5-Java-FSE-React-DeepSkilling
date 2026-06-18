public class TestAdapter {
    public static void main(String[] args) {
        // 1. Create and configure the adaptee first
        PayPalGateway gateway = new PayPalGateway();
        
        // 2. Pass it into the Adapter
        PaymentProcessor processor = new PayPalAdapter(gateway);

        processor.processPayment(1000);
    }
}
