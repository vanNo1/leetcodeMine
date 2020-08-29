package com.van.leetcode.dp;

public class 零钱兑换Two {
    public int change(int amount, int[] coins) {
        //dp:若只使用 coins 中的前 i 个硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法。
        //都从0开始
        //base case 为 dp[0][..] = 0， dp[..][0] = 1。因为如果不使用任何硬币面值，就无法凑出任何金额；如果凑出的目标金额为 0，那么“无为而治”就是唯一的一种凑法。
        int[][] dp = new int[coins.length + 1][amount + 1];
        //base case:
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
