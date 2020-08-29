package com.van.leetcode.dp;

public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][]dp=new int[len][len] ;

        //base case:
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }

        for (int times = 1; times <len; times++) {
            for (int i = times; i < len; i++) {
                if (s.charAt(i-times)==s.charAt(i)){
                    dp[i-times][i]=dp[i-times+1][i-1]+2;
                }else {
                    dp[i-times][i]=Math.max(dp[i-times][i-1],dp[i-times+1][i]);
                }
            }
        }
    return dp[0][len-1];
    }
}
