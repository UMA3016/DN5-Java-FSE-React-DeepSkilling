public class FinancialForecastApplication {

    public static void main(String[] args) {

        System.out.println("Forecasting for 5 years at 10% growth rate:");
        double result =
                FinancialForecast.forecast(
                        10000,
                        0.10,
                        5);

        System.out.println(
                "Future Value = "
                + result);

        System.out.println("\nTesting negative years validation:");
        try {
            FinancialForecast.forecast(10000, 0.10, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}