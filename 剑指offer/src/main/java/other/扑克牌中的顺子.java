package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * 如果满足以下要求，则这个nums就是个顺子
 * 1。除了0以外，其他数字不能有重复
 * 2。除了0以外，最大的数字减去最小的数字差值要小于nums.length
 *
 * 理解：
 * 例如：有5个数字，先把他们想成5个0，也就是假设nums就是个顺子
 * 现在，nums[0]和nums[4]这两个元素从0变成了数字（要维护nums是顺子），那么他们的差值正好是nums.length-1
 * 那现在假如不是头尾元素变成了数字，而是中间的任意两个元素变成了数字，那么其相差肯定是小于nums.length-1。
 * 所以如果nums中有两个数的差值大于等于nums.length那肯定不是顺子
 *
 * 除0 外其他数字不能有重复就不用多解释了
 */
public class 扑克牌中的顺子 {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        //直到第一个值不是0元素的下标
        while (index < nums.length && nums[index] == 0) {
            index++;
        }
        //如果都是0
        if (index==nums.length){
            return true;
        }
        //判断是否满足最大元素减去最小元素差值小于nums.length
        if (nums[nums.length-1]-nums[index]>=nums.length){
            return false;
        }
        //判断除了0以外有无重复的数字
        Set<Integer>set=new HashSet<>();
        for (int i = index; i <nums.length ; i++) {
            if (!set.add(nums[i])){
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        boolean s = isStraight(new int[] {8, 7, 11, 0, 9});
    }
}
