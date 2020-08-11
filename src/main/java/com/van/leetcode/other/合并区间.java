package com.van.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
