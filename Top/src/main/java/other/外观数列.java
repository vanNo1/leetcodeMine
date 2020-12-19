package other;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * <p>
 * 例如，数字字符串 "3322251" 的描述如下图：
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 思路：主要就是根据前一个String来写出后一个String
 * 根据规律可得：times（数字出现的次数）+number（数字）
 */
public class 外观数列 {
    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        for (int i = 1; i < n; i++) {
            dp[i] = getCurrent(dp[i - 1]);
        }
        return dp[n - 1];
    }

    // 根据上一个String 得到当前String，只用一个指针就行了
    public String getCurrent(String pre) {
        // 先让指针指向0的为止，初始化次数
        int times = 1;
        // 初始化number
        char number = pre.charAt(0);
        // 初始化result
        String result = "";
        // 指针从1开始到末尾
        for (int i = 1; i < pre.length(); i++) {
            // 如果下一个数字和上一个数字相等，那么让times++
            if (pre.charAt(i) == number) {
                times++;
            } else {
                // 如果下一个数字与上一个数字不等，那么倾倒一次垃圾桶，让result等于下面的公式
                result = result + String.valueOf(times) + String.valueOf(number);
                // 倒完了垃圾桶，现在再初始化number和times
                number = pre.charAt(i);
                times = 1;
            }
        }
        // 这里一定要加上，因为退出循环的时候，还要倒一次垃圾桶
        result = result + String.valueOf(times) + String.valueOf(number);
        return result;
    }

}
