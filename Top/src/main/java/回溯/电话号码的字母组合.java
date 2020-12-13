package 回溯;import java.lang.reflect.Array;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;/** * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 * <p> * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 * <p> * <p> * <p> * 示例: * <p> * 输入："23" * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. * <p> * 来源：力扣（LeetCode） * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 * * * */public class 电话号码的字母组合 {    private List<String> result = new ArrayList<>();    public List<String> letterCombinations(String digits) {        //这个要判断，不然为空通不过        if (digits.length() == 0) {            return result;        }        Map<Character, String> map = new HashMap<>();        map.put('2', "abc");        map.put('3', "def");        map.put('4', "ghi");        map.put('5', "jkl");        map.put('6', "mno");        map.put('7', "pqrs");        map.put('8', "tuv");        map.put('9', "wxyz");        StringBuilder stringBuilder = new StringBuilder();        backtrack(stringBuilder, 0, digits, map);        return result;    }    /**     *     * @param track 这里用StringBuilder 不用List<Character> 可以更好的处理字符串     * @param index 每次取digits的第index个数字     * @param digits     * @param map     */    public void backtrack(StringBuilder track, int index, String digits, Map<Character, String> map) {        if (index == digits.length()) {            result.add(new String(track));            return;        }        Character c = digits.charAt(index);        String value = map.get(c);        for (int i = 0; i < value.length(); i++) {            track.append(value.charAt(i));            backtrack(track, index + 1, digits, map);            track.deleteCharAt(track.length() - 1);        }    }}