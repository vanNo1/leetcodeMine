package com.van.leetcode.dp;

/**
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
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i < dp.length; i++) {
            // 这一段很巧妙：我要判断以上一个为底的和是否是负数，这里可以不用判断负数，直接用相加，然后与自身比较即可
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
