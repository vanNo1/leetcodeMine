package recent.other;

import java.util.PriorityQueue;

/**
 * @author Van
 * @date 2021/3/3 - 20:15
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
