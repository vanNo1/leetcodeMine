package com.van.leetcode.dp;

public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //base case
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,//insert
                            dp[i - 1][j] + 1,//delete
                            dp[i - 1][j - 1] + 1//replace
                    );
                }
            }

        }
        return dp[word1.length()][word2.length()];
    }
    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

}
