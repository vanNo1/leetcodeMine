package com.van.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    private List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track=new ArrayList<>();
        backtrack(nums,track);
        return result;

    }
    public void backtrack(int[]nums,List<Integer>track){
        if (nums.length==track.size()){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.remove(track.size()-1);
        }
    }
}
