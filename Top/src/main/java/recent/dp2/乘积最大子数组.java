package recent.dp2;

/**
 * @author Van
 * @date 2021/3/16 - 14:29
 */
public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        // 0 is min , 1 is max
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = min(nums[i], dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            dp[i][1] = max(nums[i], dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
        }
        // 巨坑！max可能是复数的呀！所以这里不能设置为0！！！
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max=Math.max(dp[i][1],max);
        }
        return max;
    }

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
