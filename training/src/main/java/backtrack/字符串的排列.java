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
   private static List<List<Character>> result = new ArrayList<>();

    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        backtrack(chars, new ArrayList<>(), visited);
        List<String> ans = new ArrayList<>();
        result.forEach(characters -> {
            String value = characters.stream().map(character -> character + "").reduce("", (o1, o2) -> o1 + o2);
            ans.add(value);
        });
        return ans.toArray(new String[ans.size()]);
    }

    public static void backtrack(char[] chars, List<Character> track, boolean[] visited) {
        if (track.size() == chars.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            visited[i] = true;
            track.add(chars[i]);
            backtrack(chars, track, visited);
            track.remove(track.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        permutation("aab");
    }
}
