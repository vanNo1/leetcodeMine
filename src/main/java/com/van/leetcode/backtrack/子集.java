package com.van.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class 子集 {
    List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track=new ArrayList<>();
        backtrack(nums,track,0);
        return result;
    }
    public void backtrack(int[]nums,List<Integer>track,int start){
        result.add(new ArrayList<>(track));
        if (start==nums.length){
            return;
        }

        for (int i=start;i<nums.length;i++){
            track.add(nums[i]);
            backtrack(nums,track,i+1);
            track.remove(track.size()-1);
        }
    }
}
