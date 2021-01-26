package dp;

/**
 * @author Van
 * @date 2021/1/26 - 11:52
 * 剪绳子，让乘积最大
 * dp[n] 把n分成至少两段的最大乘积
 */
public class 剪绳子 {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            // base case:
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                // 这里j可以增大到i-1，因为要让dp[j]也体验下后半段i
                for (int j = 1; j < i; j++) {
                    // 错误1:绳子分为两段！一段j一段（i-j） 我写成了一段i 一段i-j
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
                }
            }
            return dp[n];
        }
}
