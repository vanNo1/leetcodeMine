package dp;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * dp[i】含义：第i个丑树是dp[i-1]
 * 一个丑数肯定是由一个另一个丑数*2or3or5得到的
 * and 一个远距离的*5可能比近距离的*2要小，所以控制这两个变量：距离和乘数
 * 所以这里也用到了贪心思想
 */
public class 丑数 {
    public int nthUglyNumber(int n) {
        int two = 0, three = 0, five = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int value2 = dp[two] * 2;
            int value3 = dp[three] * 3;
            int value5 = dp[five] * 5;
            dp[i] = Math.min(value2, Math.min(value3, value5));
            if (dp[i] == value2) {
                two++;
            }
            if (dp[i] == value3) {
                three++;
            }
            if (dp[i] == value5) {
                five++;
            }
        }
        return dp[n - 1];


    }

}
