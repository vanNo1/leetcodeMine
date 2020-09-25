package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
