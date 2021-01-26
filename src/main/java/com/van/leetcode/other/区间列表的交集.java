package com.van.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 把点拿出来判断
 */
public class 区间列表的交集 {
    private List<int[]> result=new ArrayList<>();
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;
        // 有一方搞到底了就退出循环
        while (i<A.length&&j<B.length){
            // a 点代表A中的
            int a1=A[i][0];
            int a2=A[i][1];
            // b 点代表B中的
            int b1=B[j][0];
            int b2=B[j][1];
            int r1=Math.max(a1,b1);
            int r2=Math.min(a2,b2);
            if (r1<=r2){
                result.add(new int[]{r1,r2});
            }
            // 我只需要判断两个区间中后面的那个点即可，三种情况：
            if (a2<b2){
                i++;
            }
            if (a2>b2){
                j++;
            }
            if (a2==b2){
                i++;
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
