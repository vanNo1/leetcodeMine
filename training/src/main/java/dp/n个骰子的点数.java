package dp;

/**
 * @author Van
 * @date 2021/1/26 - 10:36
 * 有点不确定dp是要从0个筛子开始还是从1个筛子开始
 */
public class n个骰子的点数 {
    public double[] dicesProbability(int n) {
        // 从0个筛子开始
        int[][] dp = new int[n + 1][n * 6 + 1];
        // base case:
        for (int i = 1; i <= 6; i++) {
            // 出错1：这里一开始粗心，写成了dp[1][i] = i;
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n * 6; j++) {
                // 这里原本是k<=j-(i-1)  但其实这个转动的筛子也可以把i-1个筛子的空间给占满，反正这个情况下结果为0
                for (int k = 1; k <= 6 && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        // 出错2：直接写成了n*6  其实只有n*6-n+1种结果
        double[] result = new double[n * 6 - n + 1];
        double total = Math.pow(6, n);
        for (int i = 0; i < result.length; i++) {
            result[i] = dp[n][n + i] / total;
        }
        return result;
    }
}
