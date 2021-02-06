package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Van
 * @date 2021/2/6 - 11:59
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 总的来说，要满足两个条件即可；
 * 一个是最大值与最小值的差值要小于等于4  这里用sort
 * 第二个是除了0以外，其余的值不能有重复  这里用set
 *
 */
public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int nonZero = -1;
        // 找到第一个非0的数，这个数是最小值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZero = nums[i];
                break;
            }
        }
        // 如果最大值与最小值的差值大于4，那么不符合
        if (nums[nums.length - 1] - nonZero > 4) {
            return false;
        }
        // 接着判断除0以外的数字有无重复，这里用set！
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (!set.add(nums[i])) {
                return false;
            }
        }
        return true;
    }
}
