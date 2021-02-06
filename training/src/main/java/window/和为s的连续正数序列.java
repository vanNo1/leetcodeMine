package window;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/2 - 20:17
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        /**
         *  失误1：写成了left=0，right=0。再配合失误2，导致了输出结果为空，因为while进去无论sum比target大还是小
         *  sum都要加上right，导致了某次sum>target的时候，移除了一个0，此时sum还是大于target，而下次进入while
         *  sum又加上了right然后才开始减去有效的left。导致一些结果被跳过
         */
        int left = 1;
        int right = 1;
        int sum = 0;
        while (left <= target / 2) {
            // 失误2：写成了不加if的，默认每次进入while必定+right。这里是错误的，这导致一次while进行两次操作，+right是必定的，其次可能再减去left
            // 但我的逻辑分明就是一次进行一个操作
            if (sum < target) {
                sum += right++;
            }
            if (sum > target) {
                sum -= left++;
            }
            if (sum == target) {
                int[] array = new int[right - left];
                // 失误3：这里写成i<right 让逻辑出现错误！ 粗心了
                for (int i = 0; i < array.length; i++) {
                    array[i] = left + i;
                }
                result.add(array);
                // 失误4-5：一开始没写这段，后面写成了left++。这导致了sum又没有改变！
                sum -= left++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
