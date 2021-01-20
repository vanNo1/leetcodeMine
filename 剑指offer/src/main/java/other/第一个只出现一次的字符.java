package other;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  开辟一个新空间来辅助即可，也是弱智题
 */
public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int[] array = new int[128];
        for (int i = 0; i < s.length() ; i++) {
            array[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
