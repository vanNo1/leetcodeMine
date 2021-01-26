package dp;

/**
 * @author Van
 * @date 2021/1/26 - 14:18
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * dp我这里是从0开始，但为什么dp[0]=1?
 * 假设dp[2]也就是前两个char有几种组合?假如能构成2位数字 例如：12
 * 第一种：不构成二位数字就是dp[1]
 * 第二种：构成二位数字，就是dp[0]
 * 显然12 这种情况就有两种组合，所以dp[0]=1
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = num + "";
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 但这里别搞混了，dp[i]对应的那个char其实是str.charAt(i-1)
        for (int i = 2; i <= str.length(); i++) {
            Integer number = Integer.valueOf(str.substring(i - 2, i));
            // 怎么算符合二位数？1.前面不能为0     2.二位数不能大于25
            if (number > 9 && number <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];

    }
}
