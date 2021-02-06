package dp;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/1/28 - 10:39
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 坑：赋初值都忘了写
        Arrays.fill(dp, amount + 1);
        // base case:
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 坑：我这里写的是i>coin[j] 导致base case都用不到
                if (i >= coins[j]) {
                    // 这里dp[i-coins[j]]也忘了加一
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        // 最后还要判断一下
        return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
    }
}
