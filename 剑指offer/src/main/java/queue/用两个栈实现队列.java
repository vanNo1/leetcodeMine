package queue;

import java.util.Stack;

/**
 * 9.16
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 就是把数据倒来倒去，从一个stack到一个stack
 */
public class 用两个栈实现队列 {
    private Stack<Integer>stack1=new Stack<>();
    private Stack<Integer>stack2=new Stack<>();

//    public CQueue() {
//
//    }

    // stack1 专门用于加入数据，stack2专门用于吐出数据
    public void appendTail(int value) {
        // 如果stack2有元素，则说明这个元素列是倒序的
        while (!stack2.isEmpty()){
            // 所以要把它反转到stack1中
            stack1.push(stack2.pop());
        }
        // 到达这一步，就已经确保了stack1中的元素列是正序的， 此时只要再尾部加入元素即可
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()&&stack2.isEmpty()){
            return -1;
        }
        // 如果要吐出元素，那么一定要把元素列给倒序一下，再吐出元素
        while (!stack1.isEmpty()){
            // stack2中装入的是倒序的元素列
            stack2.push(stack1.pop());
        }
        // 吐出的话直接吐出stack2中栈尾的元素即可
        return stack2.pop();
    }
}
