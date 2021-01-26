package com.van.leetcode.other;

/**
 * @author Van
 * @date 2021/1/22 - 15:05
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 首先这道题目不能用毛毛虫爬行法，因为数组中有负数，这就不符合这个做法的逻辑，有可能毛毛虫吃了一个东西反而变小了
 *
 * 这道题用preSum的暴力破解法！
 * 注意！preSum这里有两种做法：
 * 我之前用的是：preSum[0]=nums[0] 也就是preSum[i]代表前nums[i]个nums的和
 * 公式：nums[i-j](闭区间) = preSum[j]-preSum[i-1] /if i==0-> preSum[j] 可以看到这里还要区分i==0的情况！
 * 现在用的是：preSum[0]=0  也就是preSum[i]代表前nums[i-1]个nums的和
 * 公式：nums[i,j](闭区间) = preSum[j+1]-preSum[i] 这样就做到了统一！！！
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        // 构造前缀和数组
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        int count = 0;
        // nums[i,j] -> preSum[j+1]-preSum[i]
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
