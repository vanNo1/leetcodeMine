package com.van.leetcode.window;

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 大体思路:
 *  先让窗口扩大，直到把t包括进去，然后再不断缩小窗口，并且每缩小一次就给个快照（直到不能覆盖所有t），于是继续增大窗口。。。
 *  重点1：如何知道窗口已经全部覆盖了t？
 *  ans：不能够遇到一个t的char就让valid++，因为有可能遇到的全部都是同一个char，正确的做法是要让相同的char和数量都对上才行！
 *  于是我用HashMap！need是把所有t的char给装入，一个key对应一个valid ，如果window的key等于need的key并且数量也对上了，那么valid++
 *  直到valid全部对上，我才开始缩小窗口
 *  重点2：这里的窗口有边界是虚的！在while里面才开始把右边界的char加入到window中
 */
public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c :  t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 如果由于窗口扩大包括进来的char在need中，那么我就把这个char放入window中，并且再判断valid是否可以增加了
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩（窗口此时以及全部包括字串）
            while (valid == need.size()) {
                // 如果这次窗口比上次的要小，那么进行一次快照
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 开始缩小窗口
                char c1 = s.charAt(left);
                left++;
                // 如果把t中的char给缩小掉了，那么valid--并且把window中的那个char给拿掉一个
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
