package dp;

public class 完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (itSelf(n)){
                dp[i]=1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                min = Math.min(min, dp[j] + dp[i - j]);
            }
            dp[i]=min;
        }
        return dp[n];
    }

    public boolean itSelf(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (Math.pow(sqrt, 2) == n) {
            return true;
        } else {
            return false;
        }
    }
}
