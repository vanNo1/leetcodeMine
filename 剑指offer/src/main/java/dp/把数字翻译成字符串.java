package dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：动态规划：
 * dp含义：从num下标0开始到下标i这个闭区间形成的数字它的不同组合数有dp[i]种可能
 *
 * 状态转移方程：
 * 1。如果i与i-1组成的二位数在【10，25】内，那么dp[i] = dp[i - 1] + dp[i - 2];
 * 2。否则的话， dp[i] = dp[i - 1];
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        //base case
        dp[0] = 1;
        if (str.length() == 1) {
            return dp[0];
        }
        int value = Integer.parseInt(str.substring(0, 2));
        //base case
        if (value >= 10 && value <= 25) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        if (str.length() == 2) {
            return dp[1];
        }
        for (int i = 2; i < dp.length; i++) {
            int value2 = Integer.parseInt(str.substring(i - 1, i + 1));
            if (value2 >= 10 && value2 <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
