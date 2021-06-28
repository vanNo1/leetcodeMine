package 双指针;

/**
 * @author Van
 * @date 2021/6/28 - 23:18
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 标准的“下一个排列”算法可以描述为：
 * <p>
 * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
 * 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
 * 将 A[i] 与 A[k] 交换
 * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
 * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 * 该方法支持数据重复，且在 C++ STL 中被采用。
 * <p>
 * 作者：imageslr
 * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 细节很重要
 */
public class 下一个排序 {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int[] ascendSquence = findAscendSquence(nums);
        if (ascendSquence[0] == ascendSquence[1]) {
            makeAscend(nums, 0);
        } else {
            int i = ascendSquence[0];
            int j = ascendSquence[1];
            int index = nums.length - 1;
            // 从后面找到第一个大于等于i的。坑：等于也算！！
            while (nums[index] <= nums[i] && index > 0) index--;
            swap(nums, index, i);
            makeAscend(nums, j);
        }
    }

    // 从后往前找到第一个升序序列对，如果没有就返回0，0
    // 这个函数写错很多次：没有移动j，边界问题越界
    public static int[] findAscendSquence(int[] num) {
        int j = num.length - 1;
        int i = num.length - 2;
        while (i >= 0) {
            if (num[i] < num[j]) break;
            if (i <= 0) {
                break;
            } else {
                i--;
                j--;
            }
        }
        if (i == 0 && num[i] > num[j]) {
            return new int[]{0, 0};
        } else {
            return new int[]{i, j};
        }
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    //从first位置开始，把序列升序
    public static void makeAscend(int[] num, int first) {
        int rear = num.length - 1;
        while (first < rear) {
            swap(num, first, rear);
            first++;
            rear--;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 3, 2});
    }
}
