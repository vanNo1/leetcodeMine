package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/1 - 11:14
 */
public class 组合 {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k, new ArrayList<>());
        return result;
    }

    public void backtrack(int n, int start, int k, List<Integer> track) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 失误：我瞎了？我这里写成了track.add(start);
            track.add(i);
            // 失误：这里写成了start+1！而是i+1！
            backtrack(n, i + 1, k, track);
            track.remove(track.size() - 1);
        }
    }
}
