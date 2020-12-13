package 分治;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2020/12/13 - 20:21
 */

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * <p>
 * 解题思路
 * 先用hash表统计s中每个字符出现的次数，
 * 显然如果字符c出现的次数小于k，c必然不在最长子串里面，
 * 根据这个特性可以将原始s分割成多个子串递归地求解问题，
 * 我们用一个split数组依次来存放每个分割点的索引，
 * 对每个分割区间同样求解该问题(多路的分治问题)，
 * 并取结果的最大值保存在变量ans中，
 * 此处有一个小trick（如果当前求解的子串长度比已存在的ans还要小，
 * 则没有必要求解该区间，这样可以减少不必要的计算）
 * ，最后递归的结束点就是当前求解的字符串s符合最长子串的要求。
 */
public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        //先把每一个字符出现的频率记录在count数组中
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> split = new ArrayList<>();
        //遍历每一个字符，看看他们的频率是否小于k，如果小于k那么就说明他们是一个分界，于是记录他们的index
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                split.add(i);
            }
        }
        if (split.size() == 0) {
            return s.length();
        }
        //假如有两个分界点，那么就有3段区间，加入这个，就能正好循环3次而不是2次
        split.add(s.length());
        int head = 0;
        int result = 0;
        //把每个区间再用longestSubstring函数求解。
        for (Integer index : split) {
            result = Math.max(result, longestSubstring(s.substring(head, index), k));
            head = index + 1;
        }
        return result;
    }
}
