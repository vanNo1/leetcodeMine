package com.van.leetcode.window;

/**
 * @author Van
 * @date 2021/1/22 - 11:56
 *
 * 做了半天，结果发现这道题不能用区间（毛毛虫爬行法）
 * 因为这个区间里面有负数！这完全就和我的逻辑不同了！
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int head = 0;
        int rear = 0;
        int body = nums[0];
        int result = 0;
        while (head != nums.length) {
            if (body < k) {
                if (++head == nums.length) {
                    break;
                }
                body += nums[head];
            }
            if (body >= k) {
                result = body == k ? result + 1 : result;
                if (head == rear) {
                    head++;
                    rear++;
                    if (head != nums.length) {
                        body = nums[head];
                    } else {
                        break;
                    }
                }
                body -= nums[rear++];
            }
        }
        return result;
    }
}
