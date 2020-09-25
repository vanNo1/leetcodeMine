package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
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
