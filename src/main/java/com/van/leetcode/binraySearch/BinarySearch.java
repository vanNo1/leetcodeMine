package com.van.leetcode.binraySearch;

//很普通的二分查找
public class BinarySearch {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=(l+r)/2,result=-1;
        while (r>=l){
            if (nums[mid]==target){
                result=mid;
                return result;
            }
            //mid bigger than target,r=mid-1
            if (nums[mid]>target){
                r=mid-1;
            }
            //mid less than target,l=mid+1
            if (nums[mid]<target){
                l=mid+1;
            }
            mid=(r+l)/2;
        }
        return result;
    }
}
