package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：先将数组排序，然后用i去跳，要跳到不同的数字区域（并且不是区域的最后一个数字，而是第一个，这里用到pre），然后启用left，right指针
 * 不断去判断sum，如果成功有个sum=0，left，right接着去寻找下一个值使sum=0，寻找下一个值的时候left和right也要跳出自己原来相同数字的区域
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 别忘记这一步
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            // 要让i跳出相同数字的区域
            if (pre == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 坑：这里判断的时候忘记给left+1 right-1 了
                    // 目的：为了保证不能有相同的解，所以left和right都要跳出原来相同数字的区域
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    // 前面只是跳到了边缘，这一步直接跳出
                    left++;
                    right--;
                }
            }
            // 别忘记赋值给pre
            pre = nums[i];
        }
        return result;
    }
}
