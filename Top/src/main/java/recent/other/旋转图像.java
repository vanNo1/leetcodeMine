package recent.other;

/**
 * @author Van
 * @date 2021/3/3 - 20:32
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解答:可以看下图:
 * https://leetcode-cn.com/problems/rotate-image/solution/c-tu-jie-zhuan-zhi-bu-cuo-zheng-shi-zai-x0ebt/
 * tips:
 * 思考一个3×3的，不要思考4×4的
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = row + 1; col < cols; col++) {
//                matrix[row][col] = matrix[col][row];
                swap(matrix,row,col,col,row);
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols / 2; col++) {
//                matrix[row][col]=matrix[row][cols-col-1];
                swap(matrix,row,col,row,cols-col-1);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int ii, int jj) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[ii][jj];
        matrix[ii][jj] = temp;
    }


}
