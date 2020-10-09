package array.binarysearch;

/**
 * 9.16
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 算法流程：
 * 初始化： 声明 i, j 双指针分别指向 nums 数组左右两端；
 * 循环二分： 设 m = (i + j) / 2 为每次二分的中点（ "/" 代表向下取整除法，因此恒有 i \leq m < ji≤m<j ），可分为以下三种情况：
 * 当 nums[m] > nums[j] 时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1；
 * 当 nums[m] < nums[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m；
 * 当 nums[m] = nums[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [i, m] 还是 [m + 1, j] 区间中。解决方案： 执行 j = j - 1 缩小判断范围，分析见下文。
 * 返回值： 当 i = j 时跳出二分循环，并返回 旋转点的值 nums[i] 即可。
 *
 * 二分查找
 * 最后相等的情况下我直接线性查找的
 */
public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int start=0,end=numbers.length-1;
        while (start!=end){
            int min=(start+end)/2;
            if (numbers[min]>numbers[end]){
                start=min+1;
            }
            if (numbers[min]<numbers[end]){
                end=min;
            }
            if (numbers[min]==numbers[end]){
                int res=numbers[0];
                for (int i = start; i <=end ; i++) {
                    res=Math.min(res,numbers[i]);
                }
                return res;
            }
        }
        return numbers[start];
    }

}
