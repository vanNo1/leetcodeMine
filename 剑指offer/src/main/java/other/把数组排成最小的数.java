package other;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 通过在排序时传入一个自定义的 Comparator 实现，重新定义 String 列表内的排序方法，若拼接 s1 + s2 > s2 + s1，那么显然应该把 s2 在拼接时放在前面，以此类推，将整个 String 列表排序后再拼接起来。
 *
 */
public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        List<String> stringList=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            stringList.add(nums[i]+"");
        }
        stringList.sort((s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            stringBuilder.append(stringList.get(i));
        }
        return stringBuilder.toString();
    }
}
