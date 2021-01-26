package com.van.leetcode.window;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路：
 * 要在s2中维护连续则可固定窗口大小就为s1的长度，维护乱序相等则可用数组
 * 重点是用一个128的数组来记录
 *
 */
public  class 字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length()==0||s2.length()==0||s1.length()>s2.length()){
            return false;
        }
        int len=s1.length();
        //窗口的小大固定为s1长度
        int l=0,r=l+len-1;
        //[l,r]
        int[] window=new int[128];
        int[] need=new int[128];
        //初始化窗口，把一开始的值记录一下
        for (int i = l; i <=r; i++) {
           window[s2.charAt(i)]++;
           need[s1.charAt(i)]++;
        }
        while (r<s2.length()){
            //进行判断，看看是否符合条件
            int count=0;
            for (int i = 0; i < s1.length(); i++) {
                if(window[s1.charAt(i)]==need[s1.charAt(i)]){
                    count++;
                }
            }
            if(count==s1.length()){
                //符合条件直接返回true
                return true;
            }else {
                //否则改变窗口
                // 左边界前移
                window[s2.charAt(l++)]--;
                // 右边界在不越界的前提下前移
                if (r==s2.length()-1){
                    return false;
                }else {
                    window[s2.charAt(++r)]++;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo")) ;

    }
}
