package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {
    private Stack<Integer> stack;
    private Deque<Integer> deque;

    public MinStack() {
        stack = new Stack<>();
        deque = new LinkedList<>();
    }

    // 这里有一个坑：deque.peekFirst() >= x  一定要大于等于，要不然push 0，1，0 这个用例就过不去
    public void push(int x) {
        stack.push(x);
        if (deque.size() == 0) {
            deque.offer(x);
        } else {
            if (deque.peekFirst() >= x) {
                deque.offerFirst(x);
            } else {
                deque.offerLast(x);
            }
        }

    }

    // 这个值要么在最后，要么在最前，顺序不会乱的
    public void pop() {
        Integer pop = stack.pop();
        if (pop.intValue() == deque.peek().intValue()) {
            deque.pollFirst();
        } else {
            deque.pollLast();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return deque.peekFirst();
    }
}
