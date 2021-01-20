package other;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：
 * 遍历整个string，遇到字母就加起来，遇到空格就不管他
 */
public class 翻转单词顺序 {
    private StringBuilder trashBin = new StringBuilder();
    private List<String> result = new ArrayList<>();

    public String reverseWords(String s) {
        //遍历整个s
        for (int i = 0; i <= s.length(); i++) {
            //如果遇到了空格或是已经到达了尾巴，就发动一次倾倒垃圾桶动作
            if (i == s.length() || s.charAt(i) == ' ') {
                //如果垃圾桶内有东西才需要倾倒
                if (!trashBin.toString().equals("")) {
                    result.add(trashBin.toString());
                    //倒完了之后把垃圾桶设置为空
                    trashBin = new StringBuilder();
                }
            } else {
                //现在遇到字母了，那就放入垃圾桶内
                trashBin.append(s.charAt(i));
            }

        }
        Collections.reverse(result);
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                resultString.append(result.get(i) + " ");
            } else {
                resultString.append(result.get(i));
            }

        }
        return resultString.toString();

    }


}
