/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 相当于一根线，走完一根线就把这根线往内移动（依次是：下左上右），并且不断判断是否线越界（超过了对面的那个）。
 */
public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[] {};
        }
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int x = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        while (true) {
            //from left to right
            for (int i = l; i <= r; i++) {
                result[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            //from up to bottom
            for (int i = t; i <= b; i++) {
                result[x++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            //from right to left
            for (int i = r; i >= l; i--) {
                result[x++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }
            //from bottom to up
            for (int i = b; i >= t; i--) {
                result[x++] = matrix[i][l];

            }
            if (++l > r) {
                break;
            }
        }
        return result;

    }


}
