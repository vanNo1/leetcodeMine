package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  先压入pushed中的元素，然后再与popped中的元素用while比较
 *
 */
public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int element : pushed) {
            stack.push(element);
            //这里一定要注意，任何可能会引起空指针的条件放前面！这个popped[j] == stack.peek()（逻辑放最后）
            while (j < popped.length && !stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
