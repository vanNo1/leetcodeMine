package com.van.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int currentFront = intervals[0][0];
        int currentRear = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextFront = intervals[i][0];
            int nextRear = intervals[i][1];

            if (currentRear > nextFront) {
                if (currentRear < nextRear) {
                    currentRear = nextRear;
                }
            }
            if (currentRear == nextFront) {
                currentRear = nextRear;
            }
            if (currentRear < nextFront) {
                result.add(new int[]{currentFront, currentRear});
                currentFront = nextFront;
                currentRear = nextRear;
            }
        }
        // 这里被坑了！最后结束的时候还漏了一个结果，所以一定要把它给加上去！
        result.add(new int[]{currentFront, currentRear});
        return result.toArray(new int[result.size()][]);
    }

}
