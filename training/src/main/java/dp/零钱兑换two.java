package dp;

/**
 * @author Van
 * @date 2021/1/28 - 11:07
 */
public class 零钱兑换two {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        // base case:
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1]) {
                    // 坑:这里是把两种情况相加！！不是用MAX函数
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    // 坑：这里居然忘记写了！
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
