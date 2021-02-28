package recent.dp;

/**
 * @author Van
 * @date 2021/2/28 - 11:36
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 有点麻烦，要讨论cur是否为0
 */
public class 解码方法 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            // 当前与上一个连起来的数字
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            // 分两种情况，第一种cur为0
            if (cur == '0') {
                // 若pre不为1和2那么显然构不成一个字母
                if (pre != '1' && pre != '2') {
                    return 0;
                } else {
                    // 那么就两种情况：10或20
                    dp[i + 1] = dp[i - 1];
                }
                // cur不为0
            } else if (value <= 26 && value > 10) {
                // pre不为0,其实value>10可以改为pre！=‘0’
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                // pre为0
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
