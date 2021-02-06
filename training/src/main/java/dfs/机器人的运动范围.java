package dfs;

/**
 * @author Van
 * @date 2021/2/2 - 9:57
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 *
 * <p>
 * m row , n column
 */
public class 机器人的运动范围 {
    private int count = 0;

    public int movingCount(int m, int n, int k) {
        int[][] dfs = new int[m][n];
        dfs(dfs, 0, 0, k);
        return count;
    }

    public void dfs(int[][] dfs, int i, int j, int k) {
        int m = dfs.length;
        int n = dfs[0].length;
        // 赌了一波，这里测试用例并没有100
        if (i < 0 || i >= m || j < 0 || j >= n || dfs[i][j] == 1 || i % 10 + i / 10 + j % 10 + j / 10 > k) {
            return;
        }
        count++;
        dfs[i][j] = 1;
        dfs(dfs, i + 1, j, k);
        dfs(dfs, i - 1, j, k);
        dfs(dfs, i, j + 1, k);
        dfs(dfs, i, j - 1, k);
    }
}
