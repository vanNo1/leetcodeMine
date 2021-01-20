package other;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 这个题目要考虑大数，也就是整形溢出的情况，所以用一个String来保存数字
 * n位数就搞n个0，全排列
 * 最后搞一个函数，去掉前面无用的0
 */
public class 打印从1到最大的n位数 {
    private static List<List<Character>>result=new ArrayList<>();
    public static String[] printNumbers(int n) {
        char[]nums=new char[10];
        for (int i = 0; i < nums.length ; i++) {
            nums[i]= (char) (i+'0');
        }
       backtrack(nums,new ArrayList<>(),n);

        List<String>array=new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            List<Character>characters=result.get(i);
            StringBuilder stringBuilder=new StringBuilder();
            for (int j = 0; j < characters.size(); j++) {
                stringBuilder.append(characters.get(j));
            }
            String s=trim0(stringBuilder.toString());
            if (!Strings.isEmpty(s)){
                array.add(s);
            }
        }
        return array.toArray(new String[array.size()]);
    }
    public static void backtrack(char[]nums, List<Character> track,int n){
        if (track.size()==n){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums,track,n);
            track.remove(track.size()-1);
        }
    }
     public static String trim0(String target){
        int index=0;
        while (index<target.length()&&target.charAt(index)=='0'){
            index++;
        }
        if (index==target.length()){
            return "";
        }
        return target.substring(index,target.length());

     }

    public static void main(String[] args) {
      String[]strings=  printNumbers(2);
    }
}
