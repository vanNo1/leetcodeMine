package backtrack;

import javax.print.DocFlavor;
import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 1。这里向下是不可再用用过的字母，但是向右是可以用用过的字母，是contain模式而不是i+1模式
 * 2。由于可能有char是重复的，所以要横向剪枝，在for循环选char的时候就不能出现相同的char，这里考虑用set去重
 * 3。而且原来的contain模式也有问题，如果遇到相同的char，就加不进去了，改造一下contain，现在用一个visited数组记录有无被使用过
 *
 */
public class 字符串的排列 {
    private List<List<Character>> result = new ArrayList<>();

    public String[] permutation(String s) {
        backtrack(new boolean[s.length()],s.toCharArray(),new ArrayList<>());
        //后面就是将List<List<Character>>变为string[]的部分了
        List<String> stringList=new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder stringBuilder=new StringBuilder();
            List<Character>characters=result.get(i);
            for (int j = 0; j < characters.size(); j++) {
                stringBuilder.append(characters.get(j));
            }
            stringList.add(stringBuilder.toString());
        }
        return stringList.toArray(new String[stringList.size()]);
    }

    public void backtrack(boolean[] visited, char[] s, List<Character> track) {
        if (track.size() == s.length) {
            result.add(new ArrayList<>(track));
        }
        Set<Character> set = new HashSet<>();
        //遍历从0-s.length-1
        for (int i = 0; i < s.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (set.contains(s[i])) {
                continue;
            }
            //横向剪枝
            set.add(s[i]);
            //这个部分可以当作就是原本的contain模式
            visited[i] = true;
            track.add(s[i]);
            backtrack(visited, s, track);
            track.remove(track.size() - 1);
            visited[i] = false;
            //。。。。。。。。。。。。。。。。。。。。。。
        }
    }

}
