package dfs;

import java.util.ArrayList;
import java.util.List;

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
 * 这道题用递归时间会超，只能用dp
 */
public class 礼物的最大价值 {
    private List<Integer> track = new ArrayList<>();
    private List<Integer> sumList = new ArrayList<>();

    public int maxValue(int[][] grid) {
        dfs(grid, grid[0].length - 1, grid.length - 1);
        int max = 0;
        for (int i = 0; i < sumList.size(); i++) {
            max = Math.max(max, sumList.get(i));
        }
        return max;
    }

    //一共right有grid[0].length-1  down 有grid.length-1
    //i=grid.length-1-down  j=grid[0].length-1-right
//剩了几个
    public void dfs(int[][] grid, int right, int down) {
        if (right < 0 || down < 0) {
            return;
        }
        int i = grid.length - 1 - down;
        int j = grid[0].length - 1 - right;
        track.add(grid[i][j]);
        if (right == 0 && down == 0) {
            sumList.add(sum(new ArrayList<>(track)));
        }
        //try go right
        if (right != 0) {
            dfs(grid, right - 1, down);
        }
        //try go down
        if (down != 0) {
            dfs(grid, right, down - 1);
        }
        track.remove(track.size() - 1);
    }

    public int sum(List<Integer> track) {
        int sum = 0;
        for (int i = 0; i < track.size(); i++) {
            sum += track.get(i);
        }
        return sum;
    }
}
