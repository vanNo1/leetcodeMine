package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 主要是如何每次都能够获取到queue的最大值，这是最难的点
 * deque是双端队列
 * 思路的话看那个动画
 */

public class 队列的最大值 {
    private Deque<Integer> queue;
    private Deque<Integer> maxQueue;

//    public MaxQueue() {
//        queue = new LinkedList<>();
//        maxQueue = new LinkedList<>();
//    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        //千万别忘记写!maxQueue.isEmpty()条件，否则报错
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer n = queue.pollFirst();
        if (n.intValue() == maxQueue.peekFirst().intValue()) {
            maxQueue.pollFirst();
        }
        return n;

    }
}
