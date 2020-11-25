package dfs;

/**
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 * <p>
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * <p>
 * 输入: [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * <p>
 * 输入: [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/making-a-large-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：
 * 还是和上几次一样，用dfs算面积，关于填海的话，每次只要只要假设这个是岛屿，然后再dfs即可
 * 坑：
 * 每次dfs算面积的时候，我之前是把走过的路直接设置为某一个数字（不设置的话会导致StackOverFlow），
 * 但是后面并没有把它再还原（因为之前的岛屿之间本来就不相通，下一次遍历肯定走不到之前的岛屿上）但这次的话，假如了可以填海，那么很有可能就打通某两个岛屿，
 * 那么之前走过的痕迹就会造成影响。
 * 于是：我再dfs这里一开始标记"已走过"后面再撤回"已走过"，但实际上这样用来计算面积的话会造成重复！这种做法只能用于去探索，不能用于去计数！
 * 再后面，我还是沿用之前的不撤回"已走过"，先算出面积，然后再在主函数中把之前的影响"已走过"扫除掉，代价的话是时间复杂度很高。
 *
 * 有待优化：
 *
 */
public class 最大人工岛 {
    public static int largestIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int origin = grid[i][j];
                grid[i][j] = 1;
                maxArea = Math.max(dfs(grid, i, j), maxArea);
                grid[i][j] = origin;
                sweep(grid);
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        int area = 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
        return area;
    }

    public static void sweep(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 1;
                }
            }
        }
    }


}
