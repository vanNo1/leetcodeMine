package top.other;

/**
 * @author Van
 * @date 2021/2/18 - 16:41
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                maxProfit = Math.max(prices[i] - buy, maxProfit);
            }else {
                buy=prices[i];
            }
        }
        return maxProfit;
    }
}
