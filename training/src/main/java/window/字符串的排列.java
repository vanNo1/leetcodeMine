package window;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/2/3 - 14:24
 *
 * 一开始没想出来如何判断s1 是否在 s2 中！而这个是很关键的一点！
 */
public class 字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] window1 = new int[128];
        int[] window2 = new int[128];
        int left = 0;
        int right = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            window1[s1.charAt(i)]++;
            window2[s2.charAt(i)]++;
        }
        // 这里要注意：我只保证right不越界！但这样的话少了一次判断！
        while (right < s2.length()) {
            if (check(window1, window2, s2)) {
                return true;
            }
            window2[s2.charAt(right++)]++;
            window2[s2.charAt(left++)]--;
        }
        // 于是在这里加上这个判断
        return check(window1, window2, s1);
    }

    public boolean check(int[] window1, int[] window2, String s1) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (window1[s1.charAt(i)] == window2[s1.charAt(i)]) {
                count++;
            }
        }
        return count == s1.length();
    }

}
