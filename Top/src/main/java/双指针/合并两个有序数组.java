package 双指针;


/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 *  
 * <p>
 * 提示：
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 其实这道题还有点意思的，首先，最好的方法是从后面开始遍历，可以不用额外申请空间
 * 思路：用三个指针指向两个数组有效数字末尾以及num1开始被填充的末尾，从后面开始向前遍历，遇到大的就填充
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // p1指向nums1有效数字的末尾
        int p1 = m - 1;
        // p2指向nums2有效数字的末尾
        int p2 = n - 1;
        // index指向nums1开始被填充的末尾
        int index = m + n - 1;
        // 这里很关键，测试用例会给nums2.length=0。或是m,n等于0的情况，这样的话p1，p2立马就会越界的，这一步直接过滤了越界的情况
        while (p1 >= 0 && p2 >= 0) {
            // 把大的放入index
            nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // 到达这一步，要么就是nums1走完了，要么就是nums2走完了，第二种情况这里复制等于没复制，无影响，而第一种情况可以把剩下的数字给复制到nums1中
        // 意思：将nums2 从0 开始，复制到nums1中，nums1从0开始，复制p2+1个，因为p2从0开始，所以一共是有p2+1个
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
