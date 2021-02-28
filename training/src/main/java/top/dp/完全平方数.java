package top.dp;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/2/15 - 9:50
 */
public class 完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[dp.length - 1];
    }
}
