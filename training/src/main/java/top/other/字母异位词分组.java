package top.other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Van
 * @date 2021/2/19 - 10:18
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                map.put(s,new ArrayList<>());
                map.get(s).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
