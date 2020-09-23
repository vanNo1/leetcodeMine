package queue;

import java.util.*;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *这道题和队列最大值很像，这里只要搞一个deque来维护队列的最大值就行
 *出队的元素判断一下是不是deque中的头元素（最大值元素），是的话就要让头元素从deque中出队
 *加入元素的时候判断，这个元素是否大于deque的尾元素，是的话就让尾元素出队，直到deque为空或是尾元素大于这个元素为止
 */
public class 滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int front = 0;
        int rear = k - 1;
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.offer(nums[i]);
            } else {
                //出队列这里一定要注意,一定要加上!deque.isEmpty()
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
            }
        }
        while (rear != nums.length) {
            result.add(deque.peekFirst());
            if (rear == nums.length - 1) {
                break;
            }
            if (nums[front] == deque.peekFirst()) {
                deque.pollFirst();
            }
            front++;
            rear++;
                while (!deque.isEmpty()&&deque.peekLast() < nums[rear]) {
                deque.pollLast();
            }
            deque.offerLast(nums[rear]);
        }
        int[]array=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i]=result.get(i);
        }
        return array;
    }


}
