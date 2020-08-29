package com.van.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *  示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 目标和 {
    private static int result=0;
    public static int findTargetSumWays(int[] nums, int S) {
        backtrack(new ArrayList<Integer>(),nums,S);
        return result;
    }
    public static void backtrack(List<Integer>track,int[]nums,int S){
        if (track.size()==nums.length) {
            if (sum(nums, new ArrayList<>(track)) == S) {
                result += 1;
            }
            return;
        }
            for (int i = 0; i <=1; i++) {
                if (i == 0) {
                    track.add(-1);
                }else {
                    track.add(1);
                }
                backtrack(track,nums,S);
                track.remove(track.size()-1);
            }

    }
    public static int sum(int[]nums,List<Integer>symbol){
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i]*symbol.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1};
       int resul= findTargetSumWays(nums,1);
        System.out.println(resul);
    }
}
