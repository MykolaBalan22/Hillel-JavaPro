package task1;

public class Profit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            int currentProfit = prices[i] - minValue;
            if (currentProfit > profit) {
                profit = currentProfit;
            }
        }
        return profit;
    }
}
