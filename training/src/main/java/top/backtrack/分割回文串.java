package top.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/15 - 11:06
 */
public class 分割回文串 {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        trackback(s,new ArrayList<>(),0);
        return result;
    }

    public void trackback(String s, List<String> track, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(track));
        }
        for (int i = start; i < s.length(); i++) {
            if (checkPalindrom(start, i, s)) {
                track.add(s.substring(start, i + 1));
                trackback(s, track, i + 1);
                track.remove(track.size() - 1);
            }
        }
    }

    public boolean checkPalindrom(int left, int right, String s) {
        while (left <= right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left > right;
    }
}
