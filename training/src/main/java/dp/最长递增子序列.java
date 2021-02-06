package dp;

/**
 * @author Van
 * @date 2021/1/27 - 16:09
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * dp[i]：以nums[i]为结尾的一个最长上升子序列的长度
 */
public class 最长递增子序列 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // base case:
        dp[0] = 1;
        // 失误：无语了，我这里居然写成了int i=2 从2开始，粗心了
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max == 0 ? 1 : max + 1;
        }
        // 这里也粗心了，我直接返回了dp数组中最后一个数字！最后一个数字又不是解！
        int ans=0;
        for (int value : dp) {
            ans=Math.max(ans,value);
        }
        return ans;
    }

}
