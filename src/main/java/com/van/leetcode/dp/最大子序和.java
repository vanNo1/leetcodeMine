package com.van.leetcode.dp;

public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
