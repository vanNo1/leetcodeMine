package dp;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 动态规划：
 * dp含义：dp[i][j]的含义是：i个骰子和为j的次数是dp[i][j]
 * 转移方程：
 * 让一个骰子从1丢到6，n-1个骰子和为其丢剩下的
 */
public class n个骰子的点数 {
    public double[] twoSum(int n) {
        //dp[i][j]的含义是：i个骰子和为j的次数是dp[i][j],这里dp一定要代表次数而不是概率，要不然好难算的
        //base case :
        int[][] dp = new int[n + 1][6 * n + 1];
        //只有一个骰子的时候1-6次数都是1
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //如果一个骰子也就是n==1
        if (n == 1) {
            double[] result = new double[6];
            for (int i = 0; i < 6; i++) {
                result[i] = ((double) dp[1][i + 1]) / ((double) 6);
            }
        }
        //从两个骰子到n个骰子
        for (int i = 2; i <= n; i++) {
            //n个骰子的最小点数是n（都为1），最大点数是n*6（都为6）
            for (int j = i; j <= i * 6; j++) {
                //让一个骰子从1骰到6，但这里要注意一下：这个骰子的点数k一定要小于总点数和j-剩下骰子个数（i-1）
                for (int k = 1; k <= 6 && k <= j - i + 1; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        //注意：n个骰子的可能点数区间为【n，n*6】，也就是说一共有n*6-n+1种可能
        double[] result = new double[n * 6 - n + 1];
        //所有的可能数
        double base = Math.pow(6, n);
        //把n个骰子的总概率算出来
        for (int i = 0; i < result.length; i++) {
            result[i] = ((double) dp[n][n + i]) / base;
        }
        return result;

    }
}
