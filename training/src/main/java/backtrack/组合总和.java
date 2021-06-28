package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/3/12 - 15:25
 */
public class 组合总和 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        trackback(candidates,0,new ArrayList<>(),target);
        return result;
    }

    public void trackback(int[] candidates, int start, List<Integer> track, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(track));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            target -= candidates[i];
            trackback(candidates, i, track, target);
            track.remove(track.size() - 1);
            target += candidates[i];
        }
    }

}
