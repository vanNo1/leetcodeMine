package top.other;

/**
 * @author Van
 * @date 2021/2/15 - 9:59
 */
public class 最长回文子串 {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        if (s.length() <= 1) return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.charAt(0) + "";
            }
        }
        for (int i = 1; i <= s.length() - 2; i++) {
            int left = i - 1;
            int right = i + 1;
            int len = 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
                len++;
            }
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
                len++;
            }
            while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            if (len > maxLen) {
                // 失误：居然写错了!
                maxLen = len;
                start = left + 1;
                end = right;
            }
        }
        return s.substring(start, end);
    }

}
