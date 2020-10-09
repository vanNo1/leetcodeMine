package array.binarysearch;

/**
 * 9.15
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 *
 * 站在右上角看。这个矩阵其实就像是一个Binary Search Tree。然后，聪明的大家应该知道怎么做了。
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //避免传入一个空的二维数组
        if (matrix.length == 0) {
            return false;
        }
        //避免传入一个空的二维数组
        if (matrix.length > 0) {
            if (matrix[0].length == 0) {
                return false;
            }
        }
        //从右上角开始
        int i = 0, j = matrix[0].length - 1;

        while (true) {
            //只要越界了那肯定就是没有找到
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
                return false;
            }
            int temp = matrix[i][j];
            if (temp == target) {
                return true;
            }
            if (temp > target) {
                j--;
            }
            if (temp < target) {
                i++;
            }
        }
    }

}
