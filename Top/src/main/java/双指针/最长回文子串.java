package 双指针;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：中心扩散法，把i当作回文子串中心的那个位置（回文可能是奇数，那么i就正好是正中心。回文可能是偶数，那么i可能是中心两个数的左边一个，或者右边一个）
 * 每次扩散：
 * 1.从i的左边开始扩散，遇到和s.charAt(i)相同的，左边就扩散
 * 2.从i的右边开始扩散，遇到和s.charAt(i)相同的，右边就扩散
 * 3.从i的两边喀什扩散，如果s.charAt(left)==s.charAt(right)，两边就扩散
 * 解释：假如回文串是偶数，并且此时i是中心偏左或者偏右，那么步骤1，2就能保证正好扩散到整个中心（把中心两个数字给包纳进来）
 * 因为正好包纳完了整个中心，那么第三步直接可以向两边扩散，把回文全部找出来
 *   假如回文串是奇数，i正好是中心，并且回文串每个数字各不相同，那么步骤1，2无效，而步骤3直接扩散整个回文串
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 每次i（此次循环，对应的回文串长度）
        int curLen = 1;
        int maxLen = 0;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            // 左边扩散
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                curLen++;
            }
            // 右边扩散
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
                curLen++;
            }
            // 两边扩散
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
                curLen += 2;
            }
            // 都结束之后代表此次的回文串已经全部找完，那么判断一下
            if (curLen > maxLen) {
                maxLen = curLen;
                // 此时肯定是s.charAt(left+1)==s.charAt(right-1）
                maxStart = left + 1;
            }
            // 此次找完后，再初始化一下curLen
            curLen = 1;
        }
        // 右边是不包纳进来的
        return s.substring(maxStart, maxStart + maxLen);
    }
}
