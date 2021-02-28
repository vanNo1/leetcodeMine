package top.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Van
 * @date 2021/2/13 - 10:32
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：要解决两个难点，一是如何识别左括号，二是如何让左括号识别它对应的右括号？于是我用了map!
 * 识别左括号:如果这个char是map中的key，那么它是一个左括号
 * 左括号对应右括号：压入栈的时候压入的就是左括号对应的右括号，所以识别的时候直接看是否等于即可
 * 而且要考虑两个特殊情况：1.全部都是左括号  2. 全部都是右括号
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(map.get(s.charAt(i)));
            } else {
                // 失误1：特殊情况：全部都是右括号，这种情况下如果stack为空，那么直接false，如果不为空，那么弹出来判断是否括号对应
                if (stack.isEmpty()||s.charAt(i) != stack.pop()){
                    return false;
                }
            }
        }
        // 失误2：这里不能直接返回true，要根据stack是否为空来返回，因为有可能全部都是左括号！
        return stack.isEmpty();
    }
}
