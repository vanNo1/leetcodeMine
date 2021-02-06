package 区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/2/6 - 10:23
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 最重要的思路是：先得到两个区间的的交集结果，如果left》right 说明这两个区间没有交集！
 */
public class 区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int first = 0;
        int second = 0;
        List<int[]> result = new ArrayList<>();
        while (first < firstList.length && second < secondList.length) {
            int firstLeft = firstList[first][0];
            int firstRight = firstList[first][1];
            int secondLeft = secondList[second][0];
            int secondRight = secondList[second][1];
            int left = Math.max(firstLeft, secondLeft);
            int right = Math.min(firstRight, secondRight);
            if (left <= right) {
                result.add(new int[]{left, right});
            }
            // 失误：我这里判断的是firstLeft与secondLeft，然后答案没通过
            if (firstRight < secondRight) {
                first++;
            }
            if (firstRight > secondRight) {
                second++;
            }
            if (firstRight == secondRight) {
                first++;
                second++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
