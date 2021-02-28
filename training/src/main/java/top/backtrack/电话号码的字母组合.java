package top.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Van
 * @date 2021/2/15 - 11:49
 */
public class 电话号码的字母组合 {
    public List<List<Character>> result = new ArrayList<>();
    public Map<Character, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0){
            return new ArrayList<>();
        }
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        backtrack(digits, 0, new ArrayList<>());
        List<String> ans = new ArrayList<>();
        for (List<Character> characterList : result) {
            String reduce = characterList.stream().map(character -> character + "").reduce("", (o1, o2) -> o1 + o2);
            ans.add(reduce);
        }
        return ans;

    }

    public void backtrack(String digits, int index, List<Character> track) {
        if (index == digits.length()) {
            result.add(new ArrayList<>(track));
            return;
        }
        char[] chars = map.get(digits.charAt(index));
        for (int i = 0; i < chars.length; i++) {
            track.add(chars[i]);
            backtrack(digits, index + 1, track);
            track.remove(track.size() - 1);
        }
    }

}
