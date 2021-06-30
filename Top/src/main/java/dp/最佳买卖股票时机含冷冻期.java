package dp;

/**
 * @author Van
 * @date 2021/6/30 - 22:38
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 每一天看作平行时空，每个状态都有可能发生。
 * 定义三个状态：一天之内必定是这三个状态中的一个
 * dp：无股票无冷冻
 * freezeDp：无股票，有冷冻
 * stockDp；有股票，无冷冻
 * <p>
 * 显然：假设有一天是 ：无股票，无冷冻状态-》那么它前一天可能是无股票，无冷冻状态，也可能是无股票，有冷冻状态。
 *      假设有一天是：无股票，有冷冻状态--》那么它前一天必是有股票状态。因为有股票状态卖了股票，后面的一天就变成了冷冻状态
 *      假设有一天是：有股票，无冷冻状态--》那么它前一天可能是有股票状态，也可能是无股票无冷冻状态。因为无冷冻状态才可以买股票。
 */
public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        //初值记录一下，尤其要理解stockDp，它是代表目前钱的amount
        int dp = 0;
        int freezeDp = 0;
        int stockDp = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //状态转移方程按照上面的三种情况来写。
            int newDp = Math.max(dp, freezeDp);
            int newFreezeDp = stockDp + prices[i];
            int newStockDp = Math.max(dp - prices[i], stockDp);
            dp = newDp;
            freezeDp = newFreezeDp;
            stockDp = newStockDp;
        }
        return Math.max(dp, freezeDp);
    }
}
