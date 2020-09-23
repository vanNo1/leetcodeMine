package dp;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * dp[i][j]含义：从grid[0][0]走到grid[i][j]所能够收获的最大礼物
 * 状态转移方程：dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
 * 到达dp[i][j]只可能是从两个方向过来的，要么从它左边 要么从它上面，所以从这两个中选一个最大值，再加上grid[i][j]
 */
public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        //第0列的base case：
        int col = 0;
        for (int i = 0; i < grid.length; i++) {
            col += grid[i][0];
            dp[i][0] = col;
        }
        //第0行的base case：
        int row = 0;
        for (int i = 0; i < grid[0].length; i++) {
            row += grid[0][i];
            dp[0][i] = row;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
