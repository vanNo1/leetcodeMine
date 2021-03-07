package recent.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/3/3 - 17:15
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            //left->right
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            if (++top > bottom) break;
            //top->bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            //right->left
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            if (--bottom < top) break;
            //bottom->top
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }
}
