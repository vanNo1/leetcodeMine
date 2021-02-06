package 区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/4 - 11:22
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：感觉还是垃圾桶思想，设置left与right每次去清空它
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        int left = 0;
        int right = 0;
        List<int[]> result = new ArrayList<>();
        // 让数组排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // 设置初值
        left = intervals[0][0];
        right = intervals[0][1];
        // 遍历整个intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentLeft = intervals[i][0];
            int currentRight = intervals[i][1];
            // 如果当前区间的left在这个left、right闭区间内那么将right设置为最大的
            if (currentLeft >= left && currentLeft <= right) {
                right = Math.max(right, currentRight);
            } else {
                // 不在区间内，那么倒一次垃圾桶，把它装入result
                result.add(new int[]{left, right});
                // 并且把当前区间赋值给left与right
                left = currentLeft;
                right = currentRight;
            }
        }
        // 失误：这里漏了，最后还要再加一个，并且呼应intervals.length==1的情况，如果出现这种情况，也能保证加入left与right
        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][]);
    }
}
