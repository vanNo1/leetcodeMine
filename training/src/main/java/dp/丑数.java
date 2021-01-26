package dp;

/**
 * @author Van
 * @date 2021/1/26 - 11:43
 */
public class 丑数 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        // base case:
        dp[1] = 1;
        int two = 1;
        int three = 1;
        int five = 1;
        for (int i = 2; i < dp.length; i++) {
            int value2 = dp[two] * 2;
            int value3 = dp[three] * 3;
            int value5 = dp[five] * 5;
            int min = Math.min(value2, Math.min(value3, value5));
            dp[i] = min;
            if (min == value2) {
                two++;
            }
            if (min == value3) {
                three++;
            }
            if (min == value5) {
                five++;
            }
        }
        return dp[n];
    }
}
