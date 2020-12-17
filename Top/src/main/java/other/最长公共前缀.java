package other;

/**
 *
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 *
 *
 * 思路
 * 标签：链表
 * 当字符串数组长度为 0 时则公共前缀为空，直接返回
 * 令最长公共前缀 ans 的值为第一个字符串，进行初始化
 * 遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
 * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
 * 时间复杂度：O(s)O(s)，s 为所有字符串的长度之和
 * 但是有坑：
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 * @author Van
 * @date 2020/12/17 - 10:42
 *
 */

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            String oldPrefix = prefix;
            //这里有坑：用例：[ar,a] 这种情况下prefix比current要长，会直接退出，导致prefix不被更新
            for (int j = 0; j < current.length() && j < prefix.length(); j++) {
                if (current.charAt(j) == prefix.charAt(j)) {
                    continue;
                } else {
                    //如果第一个就不同，那么不要判断了，直接return“”
                    if (j == 0) {
                        return "";
                    }
                    //那么就更新它的prefix
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
            //这里一定要加上，否则[ar,a]过不去
            //如果prefix没有被改变，那么就只有三种情况，prefix与current长度和字符相等，prefix长度小于current但字符相等，prefix长度大于current但字符相等
            //这三种情况中只有一种情况需要考虑：即 prefix长度大于current，这个时候要让prefix等于current
            if (oldPrefix.equals(prefix)) {
                if (oldPrefix.length() > current.length()) {
                    prefix = current;
                }
            }
        }
        return prefix;
    }
}
