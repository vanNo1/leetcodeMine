package com.van.leetcode.window;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * ！！我这里定义了滑动窗口的起始策略！
 * 起始的时候：
 * 1。左与右都等于0
 * 2。while循环中窗体内是还没有放值的，可以在while循环中放值
 * 3。也就是说右边界正指向的内容是还不在窗体内的，也可以说右边界是虚的
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int[] container = new int[128];
        int l = 0, r = 0, len = 0;
        // 为什么r < s.length()
        // r==s.length的时候说明值已经全部遍历过
        // 但r==s.length的时候能不能进入这个while中？显然不能，因为下面又取一个新值放入进去了，这个时候会越界
        while (r < s.length()) {
            // while循环中第一个语句才给窗体内加入东西
            container[s.charAt(r++)]++;
            // 看看前面放入的内容有没有重复
            if (container[s.charAt(r - 1)] == 1) {
                continue;
            } else {
                //出现了重复，先记录好len，r-l 正好是放入窗体内元素的个数，但这里有重复，所以要减去1
                len = Math.max(len, r - l - 1);
                //再缩小窗口，知道无重复出现
                while (container[s.charAt(r - 1)] != 1) {
                    container[s.charAt(l++)]--;
                }
            }
        }
        //因为这里的机制是出现了重复才记录一下len，若始终无重复出现，所以最后还要再用max搞一下，r-l正好是当前窗体内元素的个数，因为有边界是虚的
        return Math.max(len, r - l);
    }
}
