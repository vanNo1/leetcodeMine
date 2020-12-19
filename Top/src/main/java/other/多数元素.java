package other;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路:
 * 又复习了一边投票法。主要就是维护两个变量，count和number
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        int count = 0;
        // 将number设置为nums里面不可能会出现的一个值
        int number = Integer.MAX_VALUE;
        // 遍历整个nums
        for (int i = 0; i < nums.length; i++) {
            // 如果number没有被设置值，那么就让number等于current值，并且计数为1
            if (number == Integer.MAX_VALUE) {
                number = nums[i];
                count = 1;
            } else {
                // 如果是有值的，判断number是不是等于current，如果是的话，代表是友军，那么count++
                if (number == nums[i]) {
                    count++;
                } else {
                    // 如果不是的话代表是敌军，那么count--
                    count--;
                    // 如果被减到了0，代表死光了，那么让number取消设置的值
                    if (count == 0) {
                        number = Integer.MAX_VALUE;
                    }
                }
            }
        }
        // 这个是无差别混斗，就算是所有国家联合起来攻打最多人数的国家，最多人数的国家都会赢，更别说无差别攻击了。
        return number;
    }
}
