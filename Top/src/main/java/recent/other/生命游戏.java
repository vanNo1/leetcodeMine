package recent.other;

/**
 * @author Van
 * @date 2021/3/1 - 15:31
 * <p>
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * !!!请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 *
 * <p>
 * 题意：
 * 活-0/1-死    活着的周围8个格子里面如果有0或者1个是活着的，那么它死亡
 * 活-4/++死    活着的                       大于4个              死亡
 * 活-2/3-活    活着的                       2或者3个            还是活着
 * 死-3-活      死亡的                     正好3个活着           复活
 * <p>
 * 第一次扫描，标记：
 * 活-活 1
 * 死-死 0
 * 活-死 -1
 * 死-活 -2
 */
public class 生命游戏 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = check(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = (board[i][j] == 1 || board[i][j] == -2) ? 1 : 0;
            }
        }
    }

    public int check(int[][] board, int i, int j) {
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int count = 0;
        // 这一趟遍历了9个格子
        for (int vertical = top; vertical <= bottom; vertical++) {
            for (int parallel = left; parallel <= right; parallel++) {
                // 这一步很关键：由于题目说不能先更新某些格子然后使用他们的更新来更新其他格子，所以是1或者-1，因为他们一开始都是活着的！
                if (board[vertical][parallel] == 1 || board[vertical][parallel] == -1) {
                    count++;
                }
            }
        }
        if (board[i][j] == 1) {
            count--;
            return (count == 2 || count == 3) ? 1 : -1;
        } else {
            return count == 3 ? -2 : 0;
        }
    }

}

