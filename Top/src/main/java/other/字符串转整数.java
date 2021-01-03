package other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 前置知识：
 * 解释一下正则表达式含义（为什么是双斜杠，这是java正则表达式需要有两个反斜杠才能被解析为其他语言中的转义作用。）
 *
 * ^[\\+\\-]?\\d+
 *
 * ^ 表示匹配字符串开头，我们匹配的就是 '+'  '-'  号
 *
 * [] 表示匹配包含的任一字符，比如[0-9]就是匹配数字字符 0 - 9 中的一个
 *
 * ? 表示前面一个字符出现零次或者一次，这里用 ? 是因为 '+' 号可以省略
 *
 *  \\d 表示一个数字 0 - 9 范围
 *
 * + 表示前面一个字符出现一次或者多次，\\d+ 合一起就能匹配一连串数字了
 *
 *
 * 4.Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
 *
 * Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false
 * matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
 * Java代码示例:
 *
 * Pattern p=Pattern.compile("\\d+");
 * Matcher m=p.matcher("22bb23");
 * m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
 * Matcher m2=p.matcher("2223");
 * m2.matches();//返回true,因为\d+匹配到了整个字符串
 * 我们现在回头看一下Pattern.matcher(String regex,CharSequence input),它与下面这段代码等价
 * Pattern.compile(regex).matcher(input).matches()
 *
 * lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
 * Java代码示例:
 *
 * Pattern p=Pattern.compile("\\d+");
 * Matcher m=p.matcher("22bb23");
 * m.lookingAt();//返回true,因为\d+匹配到了前面的22
 * Matcher m2=p.matcher("aa2223");
 * m2.lookingAt();//返回false,因为\d+不能匹配前面的aa
 * find()对字符串进行匹配,匹配到的字符串可以在任何位置.
 * Java代码示例:
 *
 * 复制代码
 * Pattern p=Pattern.compile("\\d+");
 * Matcher m=p.matcher("22bb23");
 * m.find();//返回true
 * Matcher m2=p.matcher("aa2223");
 * m2.find();//返回true
 * Matcher m3=p.matcher("aa2223bb");
 * m3.find();//返回true
 * Matcher m4=p.matcher("aabb");
 * m4.find();//返回false
 * 复制代码
 *
 *
 * 5.Mathcer.start()/ Matcher.end()/ Matcher.group()
 *
 * 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.
 * start()返回匹配到的子字符串在字符串中的索引位置.
 * end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
 * group()返回匹配到的子字符串
 * Java代码示例:
 *
 * 复制代码
 * Pattern p=Pattern.compile("\\d+");
 * Matcher m=p.matcher("aaa2223bb");
 * m.find();//匹配2223
 * m.start();//返回3
 * m.end();//返回7,返回的是2223后的索引号
 * m.group();//返回2223
 *
 * Mathcer m2=m.matcher("2223bb");
 * m.lookingAt();   //匹配2223
 * m.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
 * m.end();   //返回4
 * m.group();   //返回2223
 *
 * Matcher m3=m.matcher("2223bb");
 * m.matches();   //匹配整个字符串
 * m.start();   //返回0,原因相信大家也清楚了
 * m.end();   //返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串
 * m.group();   //返回2223bb
 */
public class 字符串转整数 {
    public int myAtoi(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        int result = 0;
        // matcher有三个匹配方法，这里从头开始匹配，中间的不算进去，所以用lookingAt
        if (matcher.lookingAt()) {
            try {
                // 这里的end正好是匹配的后面一个，而字符串后面一个不算进去，所以正好的
                // 这里parse的时候如果溢出，会报错
                result = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
            } catch (Exception e) {
                result = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
