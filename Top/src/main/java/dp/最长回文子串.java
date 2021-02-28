package dp;

/**
 * 其实还有一题与这个很像，它是子序列，不是字串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 *     https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 这次用动态规划来做，上次用的是双指针之中心扩散法
 * 我们用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文。试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文。只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符，是不是减少了很多重复计算。
 * 进入正题，动态规划关键是找到初始状态和状态转移方程。
 * 初始状态，l=r 时，此时 dp[l][r]=true。
 * 状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = 0;
        // 这一步很重要，要先定好右边，然后遍历左边，如果先定好左边，遍历右边的话，会发现我要去用的状态根本没有走过
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                // 每次直接判断左是否等于右即可，等于了再去判断砍头砍尾的字串是否是回文，或者相差小于2（也就是3个数字或两个数字，这种情况下只要左等于右直接就是个回文，无需判断中间数字的情况）
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    // 判断为回文了再去比较这个
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
