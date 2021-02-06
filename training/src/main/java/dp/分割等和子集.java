package dp;

/**
 * @author Van
 * @date 2021/1/27 - 15:41
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 这里的dp还是包了个0
 * 半背包恰好装满
 */
public class 分割等和子集 {
    public static boolean canPartition(int[] nums) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int half = (int) sum / 2;
        if (sum / 2 > half) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length + 1][half + 1];
        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 失误！一开始写成了j > nums[i-1] 这样的话如果恰好能放进去的情况就不会走这个逻辑！
                if (j >= nums[i - 1]) {
                    // 如果能放入的话，就把它放入，于是在两种情况中找并集
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    // 不能放入的话，就不放入，于是只有一种情况
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
