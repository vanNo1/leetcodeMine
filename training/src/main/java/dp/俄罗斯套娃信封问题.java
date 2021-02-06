package dp;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/1/28 - 16:06
 */
public class 俄罗斯套娃信封问题 {
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==0){
            return 0;
        }
        // 失误：这里排序也写错了！是先判断第一个相不相等，如果相等，那么就用第二个来降序排序，否则用第一个来升序排序
        Arrays.sort(envelopes,(o1,o2)->o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            // 失误：无语了我居然这么粗心！这里赋值我给赋值反了！
            nums[i] =envelopes[i][1] ;
        }
        int[] dp = new int[nums.length];
        // base case
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }
        int ans = 0;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
    
}
