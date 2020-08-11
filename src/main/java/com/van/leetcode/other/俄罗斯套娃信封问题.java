package com.van.leetcode.other;

import java.util.Arrays;
import java.util.Collections;

/**
 * 总的来说，先给二维数组排好序，然后对于其第二个元素，也就是h，在这个数组里面寻找最大子序列
 * 2。最大递增子序列问题：额外开辟一个数组存放着最数组中大子序列的情况
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
