package 回溯;

/**
 * m*n 相当于要向右走m-1格，向下走n-1格
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
