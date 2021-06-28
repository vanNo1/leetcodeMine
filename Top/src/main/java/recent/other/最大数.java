package recent.other;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/3/7 - 18:49
 * <p>
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 有几个测试用例要注意：
 * 051   000
 * 前面有0 的， 和全是0 的
 */
public class 最大数 {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < strNums.length; i++) {
            strNums[i] = nums[i] + "";
        }
        Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String res = Arrays.stream(strNums).reduce("", (o1, o2) -> o1 + o2);
        int index = 0;
        // 坑：这里一定要设置index，不然会越界
        while (index < res.length() && res.charAt(index) == '0') index++;
        // 这里要考虑全是0的情况，要不然就输出了一个空字符串了
        return index == res.length() ? "0" : res.substring(index);
    }
}
