package top.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/14 - 10:57
 * <p>
 * 最大的失误！！计算面积的时候dfs不能撤销！如果撤销的话，子递归计算好了面积，但是撤销了，父递归就又会计算一次，导致面积重复计算了！
 */
public class 最大人工岛 {
    private List<int[]> sweepPosition = new ArrayList<>();

    public int largestIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int origin = grid[i][j];
                grid[i][j] = 1;
                max = Math.max(max, dfs(grid, i, j));
                sweepGrid(grid);
                grid[i][j] = origin;
                sweepPosition.clear();
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = -1;
        sweepPosition.add(new int[]{i, j});
        int result = 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
        return result;
    }

    public void sweepGrid(int[][] grid) {
        for (int i = 0; i < sweepPosition.size(); i++) {
            int[] position = sweepPosition.get(i);
            grid[position[0]][position[1]] = 1;
        }
    }
}
