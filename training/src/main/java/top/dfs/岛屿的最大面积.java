package top.dfs;

/**
 * @author Van
 * @date 2021/2/14 - 10:42
 */
public class 岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] vistied = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, vistied, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        // 失误：人都傻了，这个grid是int类型的，我这写成了grid[i][j]!='1'
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] != 1) {
            return 0;
        }
        visited[i][j] = true;
        return 1
                + dfs(grid, visited, i + 1, j)
                + dfs(grid, visited, i - 1, j)
                + dfs(grid, visited, i, j + 1)
                + dfs(grid, visited, i, j - 1);
    }

}
