package recent.dp;

import java.util.Arrays;
import java.lang.Math;

/**
 * @author Van
 * @date 2021/3/8 - 11:54
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 这里一定要设置两个dp数组：
 * maxDp[i]: 以i结尾的这段区间的乘积最大值（主dp）
 * minDp[i]: 以i结尾的这段区间的乘积最小值
 * 为什么要有minDp？因为每次都要记录一下此时最小的值，很有可能最小的值乘一个负数就变成了最大的值
 * 所以可以把minDp看作是保存的数字，辅助给maxDp来用！
 */
public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] minDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minDp[i] = min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i], nums[i]);
            maxDp[i] = max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i], nums[i]);
        }
        return Arrays.stream(maxDp).max().getAsInt();
    }

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
