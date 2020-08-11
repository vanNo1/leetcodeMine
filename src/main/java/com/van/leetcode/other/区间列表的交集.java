package com.van.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class 区间列表的交集 {
    private List<int[]> result=new ArrayList<>();
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;
        while (i<A.length&&j<B.length){
            int a1=A[i][0];
            int a2=A[i][1];
            int b1=B[j][0];
            int b2=B[j][1];
            int r1=Math.max(a1,b1);
            int r2=Math.min(a2,b2);
            if (r1<=r2){
                result.add(new int[]{r1,r2});
            }
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
