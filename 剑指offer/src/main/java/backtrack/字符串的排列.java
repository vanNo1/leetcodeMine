package backtrack;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 1。这里向下是不可再用用过的字母，但是向右是可以用用过的字母，是contain模式而不是i+1模式
 * 2。而用contain模式的时候有一个问题如果字符串中有相同的字母就会出问题，所以我把他变为nums数组记录下标位置
 * 3。
 */
public class 字符串的排列 {
    private static List<List<Integer>>result=new ArrayList<>();


    public static String[] permutation(String s) {
        int[]nums=new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i;
        }
        backtrack(new ArrayList<Integer>(),nums);
        Set<String>set=new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder stringBuilder=new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                stringBuilder.append(s.charAt(result.get(i).get(j)));
            }
            set.add(stringBuilder.toString());
        }
        String[]array=new String[set.size()];
        Iterator<String>iterator=set.iterator();
        for (int i = 0; i < array.length; i++) {
            array[i]=iterator.next();
        }
        return array;

    }
    public static void backtrack(List<Integer> track,int[]nums){
        if (track.size()==nums.length){
            result.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(track,nums);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        permutation("dazxc");
    }
}
