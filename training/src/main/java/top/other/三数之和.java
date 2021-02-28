package top.other;

import java.util.*;

/**
 * @author Van
 * @date 2021/2/18 - 10:40
 */
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result;
            if (pre==nums[i])continue;
            pre=nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            // 重大失误！又被if给坑了，如果想要每次只进行一次操作，就必须if elseif 来确保只进去一次，我一开写的if导致一次进去了多次if
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                }else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});

    }
}
