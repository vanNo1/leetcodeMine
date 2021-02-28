package 回溯;

/**
 * m*n 相当于要向右走m-1格，向下走n-1格
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 用dp做简单很多
 */
public class 不同路径 {
    private int result = 0;

    public int uniquePaths(int m, int n) {
         backtrack(m - 1, n - 1);
         return result;
    }

    public void backtrack(int right, int dowm) {
        if (right == 0 && dowm == 0) {
            result++;
            return;
        }
        right--;
        backtrack(right, dowm);
        right++;

        dowm--;
        backtrack(right, dowm);
        dowm++;
    }
}
