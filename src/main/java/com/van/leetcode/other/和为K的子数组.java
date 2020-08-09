package com.van.leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
/**
 * 前缀思想+twoSum思想
 */
public class 和为K的子数组 {
    public static int subarraySum(int[] nums, int k) {
        //preSum[i] 是[nums[0],nums[i]]区间的和
        int ans=0;
        int[]preSum=new int[nums.length];
        Map<Integer,Integer>preMap=new HashMap<>();
        preSum[0]=nums[0];
        //构造前缀和数组
        for (int i = 1; i <nums.length ; i++) {
            preSum[i]=preSum[i-1]+nums[i];
        }
        //构造前缀查找表
        for (int i = 0; i < preSum.length; i++) {
            if (!preMap.containsKey(preSum[i])){
                preMap.put(preSum[i],1);
            }else {
                preMap.put(preSum[i],preMap.get(preSum[i])+1);
            }
        }
        //求[nums[i],nums[j]]这个区间内的sum值是：preSum[j]-preSum[i-1] /if i==0-> preSum[j]
        //1.preSum[j]=k+preSum[i-1]
        //2.if i==0-> preSum[j]==k
        for (int i = 0; i < nums.length; i++) {
            //去掉重复
            if (i!=0){
                if (preMap.get(preSum[i-1])<=1){
                    preMap.put(preSum[i-1],0);
                }else {
                    preMap.put(preSum[i-1],preMap.get(preSum[i-1])-1);
                }
            }
            int target=0;
            if (i==0){
                target=k;
            }else {
                target=k+preSum[i-1];
            }
            if (preMap.containsKey(target)){
                ans+=preMap.get(target);
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        int[]arr=new int[]{-1,-1,1};
        subarraySum(arr,0);
    }
}
