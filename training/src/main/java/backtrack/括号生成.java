package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/1 - 11:28
 */
public class 括号生成 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, n);
        return result;
    }

    public void backtrack(StringBuilder track, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(track.toString());
        }
        // 失误：这里一开始没有加上小于0 不被允许的情况，导致了stackOverFlow
        if (left > right || left < 0 || right < 0) {
            return;
        }
        track.append("(");
        backtrack(track, left - 1, right);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        backtrack(track, left, right - 1);
        track.deleteCharAt(track.length() - 1);
    }
}
