public class FinancialForecast {

    /**
     * Forecasts the future value recursively.
     * 
     * Time Complexity: O(N) where N is the number of years, because we make N recursive calls.
     * Space Complexity: O(N) due to recursion stack frames.
     * 
     * Note: An iterative solution would take O(N) time and O(1) space, avoiding potential 
     * StackOverflowError for very large year values. A direct formula-based solution:
     * value * Math.pow(1 + growthRate, years) would run in O(log N) or O(1) time and O(1) space.
     */
    public static double forecast(
            double value,
            double growthRate,
            int years) {

        // Validate years input to prevent infinite recursion / StackOverflowError
        if (years < 0) {
            throw new IllegalArgumentException("Number of years cannot be negative.");
        }

        if(years == 0)
            return value;

        return forecast(
                value * (1 + growthRate),
                growthRate,
                years - 1);
    }
}