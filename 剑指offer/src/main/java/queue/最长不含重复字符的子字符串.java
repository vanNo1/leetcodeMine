package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 用队列只需要一个指针就行了，而用set需要两个指针
 */
public class 最长不含重复字符的子字符串 {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0){
                return 0;
            }
            int len = 0;
            int front = -1;
            Queue<Character> queue = new LinkedList<>();
            while (front < s.length()) {
                if (front != s.length() - 1) {
                    front++;
                }else {
                    break;
                }
                //先别真的放进去，先尝试去放，把有重复的给去掉
                if (!queue.contains(s.charAt(front))) {
                    queue.offer(s.charAt(front));
                    //每放入一个元素就更新一下最大长度len
                    len = Math.max(len, queue.size());
                } else {
                    while (!queue.isEmpty()&&queue.contains(s.charAt(front))) {
                        queue.poll();
                    }
                    //这里是被去掉了元素之后放入的，len肯定更小，这里就不用更新len了
                    queue.offer(s.charAt(front));
                }

            }
            //最后还要更新一下len，最后一次没有触发判断机制，得手动触发
            len=Math.max(len,queue.size());
            return len;

        }
}
