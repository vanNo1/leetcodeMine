package 回溯;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * @author Van
 * @date 2021/2/16 - 10:04
 *
 * 这种方式会超出时间限制
 */
public class 三数之和 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, int start, List<Integer> track) {
        if (track.size() == 3) {
            Integer sum = track.stream().reduce(0, (o1, o2) -> o1 + o2);
            if (sum == 0) {
                ans.add(new ArrayList<>(track));
            }
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
