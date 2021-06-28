package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Van
 * @date 2021/3/12 - 14:05
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 第几个格子：从0开始： (i/3)*3+j/3
 *
 * 搞三个map出来
 * rowMap代表：第0-8行 出现的数字
 * colMap代表：第0-8列 出现的数字
 * blockMap代表：第0-8个block 出现的数字
 */
public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> blockMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            blockMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                char c = board[i][j];
                int blockIndex = (i / 3) * 3 + j / 3;
                // 坑：这里要全部取反！
                if (!rowMap.get(i).add(c)
                        || !colMap.get(j).add(c)
                        || !blockMap.get(blockIndex).add(c)) {
                    return false;
                }
            }
        }
        return true;
    }


}
