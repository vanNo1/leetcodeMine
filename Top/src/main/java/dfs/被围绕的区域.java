package dfs;

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
 * 
 * 
 * 坑：
 * 1。题目的意思不是与'O'相连！而是连通的都不能被填充为'X'
 * 2。dfs之前我只在0，0处调用一次，以为就可以处理所有的。但是假如有与0，0断层的，那么就扫描不到了，因此所有在边界上的点都要调用dfs
 * 3。左右的for循环把里面的逻辑颠倒了半天没发现，导致都变成了'X'
 * 
 */
public class 被围绕的区域 {
        public void solve(char[][] board) {
            if (board.length <= 2 || board[0].length <= 2) {
                return;
            }
            // 所有在边界上的'O'点都放一次dfs去深度遍历它连通的点
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean isEdge = i == 0 || i == board.length - 1 || j == 0 || j == board[0].length-1;
                    if (isEdge&&board[i][j]=='O'){
                        dfs(board,i,j);
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 切记，这两个if不可以颠倒，之前我就是颠倒了，导致# 变 O 然后立马 O 又变成 X了，于是导致了#和O都变成了X
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }

            }
        }


        public void dfs(char[][] board, int i, int j) {
            // 如果超出边界，或者是不等于O 都直接返回
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }
            board[i][j] = '#';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }

}
