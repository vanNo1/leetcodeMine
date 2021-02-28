package other;

/**
 * @author Van
 * @date 2020/12/22 - 18:31
 * https://leetcode-cn.com/problems/missing-number/
 */
public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        int exceptSum = 0;
        for (int i = 0; i <= nums.length; i++) {
            exceptSum += i;
        }
        int factSum = 0;
        for (int i = 0; i < nums.length; i++) {
            factSum += nums[i];
        }
        return exceptSum - factSum;
    }
}
