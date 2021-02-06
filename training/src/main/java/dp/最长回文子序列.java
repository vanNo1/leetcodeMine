package dp;

/**
 * @author Van
 * @date 2021/1/27 - 16:50
 *给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
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
 * 这道题目失误多次：
 * 思想还是最长公共子串的思想：
 * 先判断首位，如果首位相等那么。。。
 * 如果首位不相等。。那么取分别去掉头和尾的字串的dp最大值
 *
 * 但这里方向完全不一样：dp最终值是在右上角而不是右下角，并且分别去头，去尾的dp位置也有变化！
 * 还有一个重点就是如何实现斜着遍历
 */
public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //base case
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int times = 1; times < s.length(); times++) {
            for (int i = 0; i < s.length() - times; i++) {
                // 我需要用i来代表j 所以得出j=times+i
                if (s.charAt(i) == s.charAt(times + i)) {
                    // 失误1：这里方向写错了，闭着眼写i-1, j-1
                    dp[i][times + i] = dp[i + 1][times + i - 1] + 2;
                } else {
                    // 失误2：和上面一样的情况：没有注意到方向和上道题不一样的问题
                    dp[i][times + i] = Math.max(dp[i + 1][times + i], dp[i][times + i - 1]);
                }
            }
        }
        // 失误3，还是方向问题，我闭着眼写右下角，其实值在右上角
        return dp[0][dp[0].length - 1];
    }
}
