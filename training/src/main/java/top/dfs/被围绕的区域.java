package top.dfs;

/**
 * @author Van
 * @date 2021/2/13 - 15:43
 */
public class 被围绕的区域 {
    public void solve(char[][] board) {
        // 失误：这里忘了写
        if (board.length <= 2) {
            return;
        }
        // 失误：我前面用了两次循环，很麻烦，不如直接循环所有
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 失误:我用了&& 其实这里不需要用&& 只要有一个条件满足，那么它就是边缘的点
                boolean isEdge = i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 这里必须进入一个，否则，前面还原出来的0又会被写成X
                if (board[i][j] == '?') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '?';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

}
