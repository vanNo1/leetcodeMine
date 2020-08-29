package com.van.leetcode.dp;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int result=0;
        int[]dp=new int[nums.length];
        //base case:
        dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]=dp[i]+1;
        }
        for (int i = 0; i < dp.length; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
