package dp;

/**
 * @author Van
 * @date 2021/1/26 - 10:29
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        //  出错1，我直接返回了，其实还要找到dp中最大的数字出来返回才行
//        return dp[dp.length-1];
        // 出错2，我这里写错了，写成了MAX_VALUE
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
