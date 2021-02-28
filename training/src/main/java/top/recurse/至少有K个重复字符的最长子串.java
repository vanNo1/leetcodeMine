package top.recurse;

import java.util.*;

/**
 * @author Van
 * @date 2021/2/12 - 11:42
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 
 */
public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        List<Integer> split = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] < k) {
                split.add(i);
            }
        }
        if (split.size() == 0) {
            return s.length();
        }
        split.add(s.length());
        int result = 0;
        int head = 0;
        for (int i = 0; i < split.size(); i++) {
            int rear = split.get(i);
            result = Math.max(result, longestSubstring((s.substring(head, rear)), k));
            head = rear + 1;
        }
        return result;
    }
}
