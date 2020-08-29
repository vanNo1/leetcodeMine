package com.van.leetcode.backtrack;

public class 目标和2 {
    private int result=0;
    private int track=0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length==0){
            return 0;
        }
        backtrack(nums,S,0);
        return result;
    }

    public void backtrack(int[] nums,int S,int index){
        if (nums.length==index){
            if (track==S){
                result+=1;
            }
            return;
        }
        track+=nums[index];
        backtrack(nums,S,index+1);
        track-=nums[index];

        track-=nums[index];
        backtrack(nums,S,index+1);
        track+=nums[index];

    }
}
