package com.van.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 生成括号 {
    List<String>result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,n,new StringBuilder());
        return result;

    }
    //right和left代表分别剩下几个右括号和几个左括号
    public void backtrack(int right,int left,StringBuilder track){
        if (right<left||right<0||left<0){
            return;
        }
        if (right==0&left==0){
            result.add(track.toString());
            return;
        }
        //尝试去放一个右括号
        backtrack(right-1,left,track.append(")"));
        track.deleteCharAt(track.length()-1);
        //尝试去放一个左括号
        backtrack(right,left-1,track.append("("));
        track.deleteCharAt(track.length()-1);
    }


}
