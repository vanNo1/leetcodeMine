package recent.stack;

import java.util.PriorityQueue;

/**
 * @author Van
 * @date 2021/3/3 - 20:15
 *
 * 1，2，3，4，5，6，7
 * 极限法思考：假设k是第三大的，并且queue把最大的几个数全装进去了（5，6，7）此时头部元素是5，现在装入4
 * 此时size超出了k于是poll掉4，很显然5是不可能被poll掉的。更别说其他情况，5肯定是躲在后面的。
 */
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size()>k)queue.poll();
        }
        return queue.peek();
    }
}
