package com.van.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;


/**
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:

        输入: n = 4, k = 2
        输出:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]
*/
public class Combine {
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1,new ArrayList<Integer>(),n,k);
        return result;
    }
    public void backtrack(int start,List<Integer>track,int n,int k){
        if (track.size()==k){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <=n ; i++) {
            track.add(i);
            backtrack(i+1,track,n,k);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {


    }
}
