package com.van.leetcode.window;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }else if (s.length()==1){
            return 1;
        }
        int[]container=new int[128];
        int l=0,r=0,len =0;
        container[s.charAt(0)]++;
        while (r<s.length()-1){
            //增大窗口并记录值的情况在container中
            container[s.charAt(++r)]++;
            if (container[s.charAt(r)]==1){
                ;
            }else {
                //出现了重复，先记录好len
                len=Math.max(len,r-l);
                //再缩小窗口，知道无重复出现
                while (container[s.charAt(r)]!=1){
                    container[s.charAt(l++)]--;
                }
            }
        }
        //因为这里的机制是出现了重复才记录一下len，若始终无重复出现，所以最后还要再用max搞一下
        return Math.max(len,r-l+1);
    }
}
