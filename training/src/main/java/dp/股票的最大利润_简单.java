package dp;

/**
 * @author Van
 * @date 2021/1/26 - 15:18
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 *
 * dp[i]:前i天（包扩第i天）可以获取的最大收益
 */
public class 股票的最大利润_简单 {
    public int maxProfit(int[] prices) {
        // 测试用例会给一个空数组
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        // base case
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            // 第i天要么卖出，要么不卖出
            // 卖出的话那么最大收益就等于prices[i]-前i天(不包括第i天，因为不可能今天买今天卖)股票的最小值
            // 不卖出的话那么最大收益等于上一天的最大收益
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            // 交易完了之后，再更新min
            min = Math.min(min, prices[i]);
        }
        return dp[dp.length-1];

    }
}
