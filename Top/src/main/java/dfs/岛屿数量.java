package dfs;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 总体思路是：用dfs把相连接的岛屿全部标记上，主函数这里遍历整个grid，重点就是如何计数，算出岛屿的个数！
 * 每次进入dfs循环，即为一次，于是我外置一个boolean开关，进去了并且符合条件就设置为true，然后在外面判断一下即可
 */
public class 岛屿数量 {
    //定义开关
    private boolean flag = false;

    public int numIslands(char[][] grid) {

        int island = 0;
        // 遍历grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 对于每一个调用dfs，让他查找
                dfs(grid, i, j);
                // 如果flag被dfs设置为true 代表这是一个岛屿
                if (flag) {
                    //个数++
                    island++;
                    // 记得一定要把flag重置！
                    flag = false;
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, int i, int j) {
        // 如果越界，或者是探索过的岛屿（'#'）再或者是水（'0'） 那么就直接返回
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '#' || grid[i][j] == '0') {
            return;
        }
        // 来到这一步说明它是一个岛屿，于是将flag设置为true
        flag = true;
        // 探索过就设置一下，免得走回头路
        grid[i][j] = '#';
        // 接着探索相连的岛屿
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
