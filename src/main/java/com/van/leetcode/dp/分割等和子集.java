package com.van.leetcode.dp;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int capacity = 0;
        for (int num : nums) {
            capacity += num;
        }
        if (capacity % 2 != 0) {
            return false;
        }
        capacity /= 2;
        boolean[][] dp = new boolean[ nums.length + 1][capacity + 1];
        //东西从0开始，容量也是从0开始,dp[i][j:用i种东西能不能恰好放入capacity为j的背包
        //base case
        dp[0][0] = true;
        //capacity为0,代表不用装就能成功
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = true;
        }
        //没有东西怎么去放入背包,那肯定都是false
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //capacity not enough
                if (j<nums[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //capacity is enough
                    dp[i][j]=(dp[i-1][j]||dp[i-1][j-nums[i-1]]);
                }
            }

        }
        return dp[nums.length][capacity];
    }
}
