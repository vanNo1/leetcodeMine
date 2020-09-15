package array.twopoint;

/**
 * 9.15
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * 复习一下快排
 * 双指针
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        //先把两个指针放在初始位置上
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (nums[l] % 2 == 1 && l < nums.length && l < r) {
                l++;
            }
            while (nums[r] % 2 == 0 && r > -1 && l < r) {
                r--;
            }
            //只要停下来了就说明可以互换了
            swap(l, r, nums);
        }
        return nums;
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
