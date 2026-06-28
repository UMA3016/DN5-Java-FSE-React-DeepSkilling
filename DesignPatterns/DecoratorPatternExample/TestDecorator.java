public class TestDecorator {

    public static void main(String[] args) {

        Notifier notifier =
                new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                new EmailNotifier()));

        notifier.send("Server Down");
    }
}