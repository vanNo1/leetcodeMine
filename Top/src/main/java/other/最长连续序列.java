package other;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Van
 * @date 2021/6/14 - 22:12
 *
 * 这是一个时间复杂度为n的算法
 * 核心思路是找最左边界的那个数字：先把所有数组放入set，然后去遍历数组中每个数字
 * 如果这个数字-1在set中，那么跳过（因为这个数字肯定不是最左便边界的数字）
 * 如果这个在set中，那么就开始查找。
 *
 * 乍一看是双重循环的，但其实这个解法，每一个数字都最多被轮询两次！-》就是有很多组，但每组只有两个数字。
 * 所以复杂度是n级别
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int length = 0;
                while (set.contains(num++)) {
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
