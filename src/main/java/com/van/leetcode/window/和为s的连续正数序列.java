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
 * 注意这里说的是答案要连续的正整数序列! 比如target是6， ans不能是【3，3】 这个不是连续序列
 *
 * * ！！我这里定义了滑动窗口的起始策略！
 *  * 起始的时候：
 *  * 1。左与右都等于0
 *  * 2。while循环中窗体内是还没有放值的，可以在while循环中放值
 *  * 3。也就是说右边界正指向的内容是还不在窗体内的，也可以说右边界是虚的
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        // 这里为什么为target的一半?
        // 假如这里是奇数的话，left会正好取到target的一半。比如9，那么left=4，right=5
        // 假如这里是偶数的话，left都根本不会取到target的一半
        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
