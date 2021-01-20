package com.van.leetcode.dp;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 *  
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
 * *mark difficult
 *
 * 这个dp数组的遍历，整个遍历下来：是一个正方形右上角部分形成的一个三角形
 * 每次遍历都是由左上角开始遍历到右下角
 *
 * case：
 *      ██████      要判断这个
 *       ████         如果它的头尾相等，那么就用这段dp+2
 *    █████         否则：用这段dp和下面一段dp取最大的出来
 *     █████
 */
public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][]dp=new int[len][len] ;

        //base case:
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }

        // i的话每次从0开始，最大值每次减少一，j的话每次加一开始，最大值每次都是s.len-1
        // times就代表是从左上角到右下角的层数！
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
