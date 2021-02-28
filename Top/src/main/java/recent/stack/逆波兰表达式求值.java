package recent.stack;

import java.util.Stack;

/**
 * @author Van
 * @date 2021/2/28 - 16:00
 *
 * 比较弱智
 */
public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (cur.equals("+")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first+second);
            } else if (cur.equals("-")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first-second);
            } else if (cur.equals("*")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first*second);
            } else if (cur.equals("/")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first/second);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
