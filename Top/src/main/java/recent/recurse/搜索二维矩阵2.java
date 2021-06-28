package recent.recurse;

/**
 * @author Van
 * @date 2021/3/8 - 15:13
 * <p>
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class 搜索二维矩阵2 {
    private int[][] matrix;
    private int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        return curseFind(0, matrix[0].length - 1);
    }

    public boolean curseFind(int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return false;
        if (matrix[i][j] == target) return true;
        if (matrix[i][j] < target) {
            return curseFind(i + 1, j);
        } else {
            return curseFind(i, j - 1);
        }
    }
}
