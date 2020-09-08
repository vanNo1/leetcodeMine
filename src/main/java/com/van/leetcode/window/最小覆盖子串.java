package com.van.leetcode.window;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        int left=0,right=0,start=0,len=Integer.MAX_VALUE,valid=0;
        int[]need=new int[128];
        int[]window=new int[128];
        int validSize=0;
        //初始化need
        for (int i = 0; i <t.length() ; i++) {
            need[t.charAt(i)]++;
        }
        for (int i = 0; i < need.length; i++) {
            if (need[i]>0){
                validSize++;
            }
        }
        //大while（当right走到尽头）
        while (right<s.length()){
            char r=s.charAt(right);
            right++;
            if (need[r]>0){
                window[r]++;
                if (window[r]==need[r]){
                    valid++;
                }
            }
            while (valid==validSize){
                char l=s.charAt(left);
                if (right-left<len){
                    len=right-left;
                    start=left;
                }
                if (window[l]==need[l]){
                    valid--;
                }else {
                    window[l]--;
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,len);
            //每次取出窗口中一个char判断在不在need中
            //如果在need中且恰好数量就为need，valid++，否则只是window【char】++
            //小while（当valid==need。size）
                //若窗口长度下于len，那么更新len，且让start=left
                //把窗口最左边的char取出来
                //若char在need中且数量恰好为need。valid--，否则只是把window【char】--
    }
}
