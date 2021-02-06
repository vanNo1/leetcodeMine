package window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Van
 * @date 2021/2/3 - 15:12
 *
 * right是虚的
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            window[s.charAt(right++)]++;
            if (window[s.charAt(right - 1)] == 2) {
                // 注意这里已经出现重复了，所以是right-left-1
                maxLen = Math.max(maxLen, right - left - 1);
                while (window[s.charAt(right - 1)] == 2) {
                    window[s.charAt(left++)]--;
                }
            }
        }
        //失误1：这里忘了还要加一次，直至最后是while循环导致退出的，那么还要判断一下这个窗口最后的大小，看看有无大于maxLen，注意这里是right-left因为无重复
        maxLen = Math.max(maxLen, right - left);
        //如果一次都没有被snapshot的话，那么肯定就是返回s.length() 可以防止s.length=0/=1 特殊情况
        return maxLen == 0 ? s.length() : maxLen;
    }
}
