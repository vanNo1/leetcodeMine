package dp;

/**
 * @author Van
 * @date 2021/1/26 - 11:16
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *  
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 这道题目我没有完全理解，它的意思是只包含2，3，5，如果我这样做的话，2*7=14， 但是14包含了7，7不是丑数
 * 因为它说因子要只包含这3个才行
 * 所以我这种做法是错误的
 */
public class 丑数逻辑出错 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int value2 = 1;
        int value3 = 1;
        int value5 = 1;
        for (int i = 2; i <= n; i++) {
            int min = min(value2 * 2, value3 * 3, value5 * 5);
            if (min == value2 * 2) {
                value2++;
            }
            if (min == value3 * 3) {
                value3++;
            }
            if (min == value5 * 5) {
                value5++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
