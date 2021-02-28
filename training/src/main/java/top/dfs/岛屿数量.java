package top.dfs;

/**
 * @author Van
 * @date 2021/2/14 - 10:27
 *
 * 重点是如何让dfs与外界通讯！只要进入dfs并且满足了它是快陆地的话，那么就把isLand开关给打开。dfs中只能够打开开关，不具备关闭开关的能力
 * 所以只要进入了dfs就一定会把开关打开。用这个机制来与外界通讯！！！
 */
public class 岛屿数量 {
    private boolean isLand = false;

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, visited, i, j);
                if (isLand) {
                    count++;
                    isLand = false;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        // 如果越界，如果走过了，如果它不是一块陆地
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] != '1') {
            return;
        }
        isLand = true;
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
