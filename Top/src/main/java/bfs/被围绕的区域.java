package bfs;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 被围绕的区域 {
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        dfs(board, 1, 1);
    }

    public void dfs(char[][] board, int i, int j) {
        if (i <= 0 || i >= board.length-1 || j <= 0 || j >= board[0].length-1) {
            return;
        }
        if (board[i][j] == 'O') {
            if (i == 1) {
                if (board[0][j] == 'O') {
                    return;
                }
            }
            if (j == 1) {
                if (board[i][0] == 'O') {
                    return;
                }
            }
            board[i][j] = 'X';
        }
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

}
