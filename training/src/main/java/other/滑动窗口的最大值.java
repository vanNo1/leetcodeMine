package other;

import java.time.temporal.Temporal;
import java.util.*;

/**
 * @author Van
 * @date 2021/2/6 - 12:14
 * <p>
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 主体思路：
 * 用一个deque保存最大值，加入的时候用粉碎思想，把小于此值的都给粉碎，然后加入此值
 * poll的时候，如果要被poll的对象就是deque的head，那么就poll出deque的head，否则啥也不做
 *
 * 走了几个弯路：我用了优先队列来做，其实不行，优先队列把所有元素都加入了！
 * 第二个我想把baseCase 合并起来，写在一个循环里面，当这个deque.size()==k我才snapshot，这里我忽略了deque的size是不满的
 *
 */
public class 滑动窗口的最大值 {
    Deque<Integer> deque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < k; i++) {
            offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            result.add(deque.peekFirst());

            if (nums[left] == deque.peekFirst()) {
                deque.pollFirst();
            }
            left++;

            offer(nums[i]);
        }
        // 这里还差一次，还要snapshot一次
        result.add(deque.peekFirst());
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void offer(int num) {
        while (deque.size() != 0 && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offerLast(num);
    }

}
