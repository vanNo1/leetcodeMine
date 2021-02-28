package top.other;

/**
 * @author Van
 * @date 2021/2/18 - 16:46
 */
public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
