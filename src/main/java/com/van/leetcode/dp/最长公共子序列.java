package com.van.leetcode.dp;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * dp含义：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]
 * case：
 * text1=“abc” text2=“abcd”
 * dp[1][1]:等于是判断"a"与"a"的LCS
 * 所以先判断下"a"是否等于"a"：这两个相等，于是我要得到他们俩分别去掉一个char的dp：""与""的LCS，
 * 于是这里直接可以看出，他们俩的是0，呢么0+1=1 所以"a" and "a" 's LCS=1
 *
 * 同时也可以看出，dp[i][j]的含义是：s1[0-i-1] 与s2[0-j-1]这两段String 的LCS
 */
public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][]dp=new int[len1+1][len2+1];
        for (int i = 1; i <=len1; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
