package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Van
 * @date 2021/1/29 - 11:07
 */
public class 字符串的排列 {
    private List<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        backtrack(s.toCharArray(),new StringBuilder(),new boolean[s.length()]);
        return result.toArray(new String[result.size()]);
    }

    public void backtrack(char[] chars, StringBuilder track, boolean[] visited) {
        if (track.length() == chars.length) {
            result.add(track.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            visited[i] = true;
            track.append(chars[i]);
            backtrack(chars, track, visited);
            visited[i] = false;
            track.deleteCharAt(track.length() - 1);
        }
    }

}
