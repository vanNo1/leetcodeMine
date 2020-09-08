package com.van.leetcode.other;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 总的来说，先给二维数组排好序，然后对于其第二个元素，也就是h，在这个数组里面寻找最大子序列
 * 2。最大递增子序列问题：额外开辟一个数组存放着最数组中子序列的情况
 */
public class 俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        //给二维数组排序
        Arrays.sort(envelopes,(o1,o2)->o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        int[]son=new int[envelopes.length];
        //构造最大子序列数组
        for (int i = 0; i < son.length; i++) {
            int maxLength=0;
            for (int j = 0; j <i ; j++) {
                if (envelopes[j][1]<envelopes[i][1]){
                    maxLength=Math.max(maxLength,son[j]);
                }
            }
            son[i]=maxLength+1;
        }
        //把最大子序列数组中最大的值找出来即可，这就是最大的递增子序列
        int max=0;
        for (int i = 0; i < son.length; i++) {
            max=Math.max(max,son[i]);
        }
        return max;
    }

}
