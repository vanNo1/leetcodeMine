package recent.other;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/3/3 - 15:42
 *
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 摆动排序2 {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int length = nums.length - 1;
        Arrays.sort(copy);
        for (int i = 1; i < nums.length; i += 2) {
            //遍历完成后 x 6 x 5 x 4
            nums[i] = copy[length--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            //便利完成后 3 6 2 5 1 4
            nums[i] = copy[length--];
        }
    }
}
