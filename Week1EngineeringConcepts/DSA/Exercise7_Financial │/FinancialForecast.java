public class FinancialForecast {

    public static double forecast(
            double value,
            double growthRate,
            int years) {

        if(years == 0)
            return value;

        return forecast(
                value * (1 + growthRate),
                growthRate,
                years - 1);
    }
}