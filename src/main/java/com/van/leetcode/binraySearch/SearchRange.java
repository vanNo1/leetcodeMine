package com.van.leetcode.binraySearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]

 */
public class SearchRange {
    //就是先用二分查找，然后找到之后分别找mid左边右边的元素。
    public static int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=(r+l)/2,result1=-1,result2=-1;
        while (r>=l){
            if (nums[mid]==target){
                //to left
                for (result1=mid;result1>=l;result1--){
                    if (nums[result1]==nums[mid]){
                        continue;
                    }else {
                        break;
                    }
                }
                //to right
                for (result2=mid;result2<=r;result2++){
                    if (nums[result2]==nums[mid]){
                        continue;
                    }else {
                        break;
                    }
                }
                return new int[]{result1+1,result2-1};
            }
            if (nums[mid]>target){
                r=mid-1;
            }
            if (nums[mid]<target){
                l=mid+1;
            }
            mid=(r+l)/2;

        }
        return new int[]{result1,result2};
    }

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10},6);
        System.out.println("1");
    }

}

