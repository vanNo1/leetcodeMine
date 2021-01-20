package dp;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 *
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 动态规划解析：
 * dp[i]:前 i 日的最大利润
 * 状态转移：
 * 前i日的最大利润等于Max（dp【i-1】，prices【i】-min（prices【i-1】））
 * 解释：
 * 要么就不用第i个prices中的值，那么就是dp【i-1】，要么就用上第i个，那么就是prices[i]-（prices[i-1]数组中最小值）
 *

 */
public class 股票的最大利润 {
    public static int maxProfit(int[] prices) {
            if (prices.length==0){
                return 0;
            }
        int[]dp=new int[prices.length];
        int min=prices[0];
        for (int i = 1; i <dp.length ; i++) {
            min=Math.min(min,prices[i]);
            dp[i]=Math.max(dp[i-1],prices[i]-min);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
}
