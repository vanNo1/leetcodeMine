package com.van.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]>result=new ArrayList<>();
        int[]current=intervals[0];
        for (int i = 1; i <intervals.length ; i++) {
            int[]temp=intervals[i];
            if (temp[0]<current[1]){
                if (temp[1]>current[1]){
                    current[1]=temp[1];
                }
            }
            if (temp[0]==current[1]){
                current[1]=temp[1];
            }
            if (temp[0]>current[1]){
                result.add(current);
                current=temp;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }

}
