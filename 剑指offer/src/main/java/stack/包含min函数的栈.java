package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 利用一个stack和一个deque
 * 维护最小值：
 * 每次push一个值的时候：
 * 如果这个值比deque中头部元素小，那么就把它加如deque 的头部，否则加入deque的尾部
 * 那么这个deque 的头部元素就是整个stack所有元素中的最小值
 * 每次pop一个值的时候：
 * 判断一下这个值是不是deque 的头部元素，如果是的话那就把deque的头部元素remove，否则remove尾部元素（总有一个元素是这个值。不是deqye的头部就是它尾部）
 *
 */
public class 包含min函数的栈 {
    private Stack<Integer>stack;
    private Deque<Integer> minQueue;
//    public MinStack() {
//        stack=new Stack<>();
//        minQueue=new LinkedList<>();
//    }

    public void push(int x) {
        stack.push(x);
        if (minQueue.isEmpty()){
            minQueue.offerFirst(x);
        }else {
            if (x>minQueue.peekFirst()){
                minQueue.offerLast(x);
            }else {
                minQueue.offerFirst(x);
            }
        }

    }

    public void pop() {
        if (!stack.isEmpty()){
            int p=stack.pop();
            if (p==minQueue.peekFirst()){
                minQueue.pollFirst();
            }else {
                minQueue.pollLast();
            }
        }
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return minQueue.peekFirst();
    }
}
