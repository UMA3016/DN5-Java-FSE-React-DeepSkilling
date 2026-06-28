public class TestStrategy {

    public static void main(String[] args) {

        PaymentContext context =
                new PaymentContext(new CreditCardPayment());

        context.execute(5000);

        context =
                new PaymentContext(new PayPalPayment());

        context.execute(3000);
    }
}