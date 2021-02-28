package top.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Van
 * @date 2021/2/13 - 10:09
 */
public class MinStack {
    private Stack<Integer> stack;
    private Deque<Integer> deque;

    public MinStack() {
        stack = new Stack<>();
        deque = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (deque.isEmpty()) {
            deque.offer(x);
        } else {
            // 失误：这里要x<= 否则出现 小大小，这种情况就回出问题了：如果不加等于，那么小大小在deque中排序列顺序也是小大小，那么pop一次，把小的pop了，再取min，得到的是大
            if (x <= deque.peekFirst()) {
                deque.offerFirst(x);
            } else {
                deque.offerLast(x);
            }
        }

    }

    public void pop() {
        int num = stack.pop();
        if (num == deque.peekFirst()) {
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
