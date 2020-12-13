package com.van.leetcode.window;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 用滑动窗口
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int half = target / 2 + 1;
        //别从right=-1 left=0开始，不然0会被输出出来
        int right = 0, left = 1;
        List<int[]> track=new ArrayList<>();
        int result=0;
        while (right < half + 1) {
            if (result<target){
                result+=++right;
                continue;
            }
            if (result==target){
                track.add(new int[]{left,right});
                result-=left++;
                result+=++right;
                continue;
            }
            if (result>target){
                result-=left++;
            }
        }
        int[][]array=new int[track.size()][];
        for (int i = 0; i < array.length; i++) {
            int length=track.get(i)[1]-track.get(i)[0]+1;
            int[]temp=new int[length];
            int start=track.get(i)[0];
            int end=track.get(i)[1];
            for (int j = start; j <= end; j++) {
                temp[j-start]=j;
            }
            array[i]=temp;
        }
        return array;
    }
}
