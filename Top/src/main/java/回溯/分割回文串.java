package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 判断回文数这里很巧妙，用这种方式很快，而且代码很少
 * tips：s本身也算一个组合
 */
public class 分割回文串 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> track = new ArrayList<>();
        backtrack(track, s, 0);
        return result;
    }

    public void backtrack(List<String> track, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (checkPalindrome(s, start, i)) {
                track.add(s.substring(start, i + 1));
                backtrack(track, s, i + 1);
                track.remove(track.size() - 1);
            }
        }
    }

    public boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }


}
