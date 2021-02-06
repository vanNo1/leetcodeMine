package other;

import java.util.Collections;
import java.util.Stack;

/**
 * @author Van
 * @date 2021/2/6 - 11:09
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        // 失误1：我把这一步弄到了后面，结果k已经变了，但我忽略了这一点
        int remain = num.length() - k;
        // 失误2：我这里真的用了stack，导致后面取出来还要reverse一下很麻烦
        StringBuilder stack = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (stack.length() != 0 && stack.charAt(stack.length() - 1) > c && k > 0) {
                stack.deleteCharAt(stack.length() - 1);
                // 失误3：这里忘了k--
                k--;
            }
            // 失误4：这里忘了append
            stack.append(c);
        }
        // 失误5：这里把delete当成了subString，导致我放的参数是：0，remain
        stack.delete(remain, stack.length());
        // 失误6：忘记去掉前导0，并且忘记了第一个约束条件，stack.length()!=0
        while (stack.length() != 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }
        return stack.length() == 0 ? "0" : stack.toString();
    }
}
