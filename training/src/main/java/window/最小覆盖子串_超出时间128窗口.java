package window;

/**
 * @author Van
 * @date 2021/2/4 - 9:52
 * t is short
 */
public class 最小覆盖子串_超出时间128窗口 {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int minLeft = 0;
        int minRight = 0;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] windowS = new int[128];
        int[] windowT = new int[128];
        for (int i = 0; i < t.length(); i++) {
            windowT[t.charAt(i)]++;
        }
        while (right < s.length()) {
            windowS[s.charAt(right++)]++;
            while (check(windowS, windowT, t)) {
                if (minLen > right - left) {
                    minLen = right - left;
                    minRight = right;
                    minLeft = left;
                }
                windowS[s.charAt(left++)]--;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }

    // 失误2：这里是只要windowS>=windowT 即可，因为可能s="abcabc" t="aab" t有重复的char
    public static boolean check(int[] windowS, int[] windowT, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (windowS[t.charAt(i)] < windowT[t.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

}
