package recent.other;

/**
 * @author Van
 * @date 2021/3/3 - 16:10
 * <p>
 * ps:第一种partition和第二种partition并不能把数组排序完，而是只能给出一个准确的位置，而等于1的这部分会被分散到两处，
 * 不能聚集起来。
 * 这个方法其实就是三路快排，只有三路才能排序完整个数组。
 * left和right都是虚的
 */
public class 颜色分类 {
    public void sortColors(int[] nums) {
        //[0,left)是小于1的部分
        int left = 0;
        //(right,nums.length-1]是大于1的部分
        int right = nums.length - 1;
        // [left,i-1]是等于1的部分
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                //注意，这种情况不能i++，因为从right这里交换过来的数字不确定，还要再判断一次
                right--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
