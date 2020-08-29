package com.van.leetcode.dp;

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int capacity = 0;
        for (int num : nums) {
            capacity += num;
        }
        if (capacity % 2 != 0) {
            return false;
        }
        capacity /= 2;
        boolean[][] dp = new boolean[ nums.length + 1][capacity + 1];
        //东西从0开始，容量也是从0开始,dp[i][j:用i种东西能不能恰好放入capacity为j的背包
        //base case
        dp[0][0] = true;
        //capacity为0,代表不用装就能成功
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = true;
        }
        //没有东西怎么去放入背包,那肯定都是false
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //capacity not enough
                if (j<nums[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //capacity is enough
                    dp[i][j]=(dp[i-1][j]||dp[i-1][j-nums[i-1]]);
                }
            }

        }
        return dp[nums.length][capacity];
    }
}
