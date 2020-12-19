package other;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * 就是把它看作是26进制的来算：就类比是1234，result先为1，从2-4，result*10+current： 10+2-》12*10+3-》123*10+4-》1234
 */
public class Excel表列序号 {
    public int titleToNumber(String s) {
        // 先把第一位写下来
        int result = s.charAt(0) - 'A' + 1;
        // 从第二位开始到结束
        for (int i = 1; i < s.length(); i++) {
            // 把result*进制+当前位
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
