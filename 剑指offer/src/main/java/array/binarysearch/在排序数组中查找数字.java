package array.binarysearch;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 二分递归算法：
 */
public class 在排序数组中查找数字 {
    private int count=0;
    public int search(int[] nums, int target) {
        recurse(nums,0,nums.length-1,target);
        return count;
    }
    // 递归的去判断(low+high)/2 的index位置是不是等于target，是的话就将count++并且区间一分为二，不是的话就缩小区间
    public void recurse(int[]nums,int low,int high,int target){
        if (low>high)return;
        int mid=(low+high)/2;
        if (nums[mid]==target){
            count++;
            recurse(nums,low,mid-1,target);
            recurse(nums,mid+1,high,target);
        }
        if (nums[mid]<target){
            recurse(nums,mid+1,high,target);
        }
        if (nums[mid]>target){
            recurse(nums,low,mid-1,target);
        }
    }
}
