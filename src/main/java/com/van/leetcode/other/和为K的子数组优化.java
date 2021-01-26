package com.van.leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
/**
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 前缀思想+twoSum思想
 * 这里还是没懂，先放弃
 */
public class 和为K的子数组优化 {
    public static int subarraySum(int[] nums, int k) {
//        preSum[i] 是[nums[0],nums[i]]区间的和
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
}
