package array.dp;

/**
 * 9.15
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * dp数组的含义： dp[i] 为以num[i] 结尾的最大连续子串和
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i <nums.length; i++) {
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
