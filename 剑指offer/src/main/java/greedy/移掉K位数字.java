package greedy;

import java.util.concurrent.*;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 贪心栈：把栈用StringBuild代替
 *
 */
public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        int remain=num.length()-k;
        if (remain==0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        //遍历所有的char，如果这个char要小于前面的的元素那么就让它不断出栈
        for (char c : num.toCharArray()) {
            while (stringBuilder.length() != 0&&k>0&&stringBuilder.charAt(stringBuilder.length() - 1) > c){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                k--;
            }
            stringBuilder.append(c);
        }
        //只保留前remain个就行了
        stringBuilder.delete(remain,stringBuilder.length());
        // 去除前面的0
        while (stringBuilder.length()!=0&&stringBuilder.charAt(0)=='0'){
            stringBuilder.deleteCharAt(0);
        }
        //防止0000都是0的情况
        return stringBuilder.length()==0?"0":stringBuilder.toString();
    }

}

