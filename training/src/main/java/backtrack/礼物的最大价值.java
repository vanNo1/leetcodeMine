package backtrack;

/**
 * @author Van
 * @date 2021/1/30 - 10:52
 *
 * 这道题用backtrack是ok的，但是超出了时间限制，它只想让你用dp做
 */
public class 礼物的最大价值 {
    private int maxValue = 0;

    public int maxValue(int[][] grid) {
        int down = grid.length - 1;
        int right = grid[0].length - 1;
        backtrack(grid,down,right,grid[0][0]);
        return maxValue;
    }

    public void backtrack(int[][] grid, int down, int right, int value) {
        if (down == 0 && right == 0) {
            maxValue = Math.max(maxValue, value);
            return;
        }
        int positionI = grid.length - down - 1;
        int positionJ = grid[0].length - right - 1;
        if (down != 0) {
            value += grid[positionI + 1][positionJ];
            backtrack(grid, down - 1, right, value);
            value -= grid[positionI + 1][positionJ];
        }
        if (right != 0) {
            value += grid[positionI][positionJ + 1];
            backtrack(grid, down, right - 1, value);
            value -= grid[positionI][positionJ + 1];
        }
    }
}
