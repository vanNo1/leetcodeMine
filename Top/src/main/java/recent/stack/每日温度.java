package recent.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Van
 * @date 2021/3/12 - 19:46
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 维护一个单调递减栈（装的是下标），每次比较新加入的数字和这个栈的last，如果大于last那么就把last弹出，再它的结果res上
 * 写上它的值：i-last(index)，不断用while循环来搞
 *
 * 总之最重要的一点是用stack来维护一个单调递减的（但stack装的是数字的index，因为后面计算的时候要用index来算）
 *
 *
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            // 坑：这里一定要判断deque.size()!=0 要不然的话会报错：空指针
            while (deque.size() != 0 && T[deque.peekLast()] < T[i]) {
                Integer last = deque.pollLast();
                res[last] = i - last;
            }
            deque.offerLast(i);
        }
        return res;
    }
}
