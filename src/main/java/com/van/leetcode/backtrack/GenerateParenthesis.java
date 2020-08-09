package com.van.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
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
        }
        //尝试去放一个右括号
        backtrack(right-1,left,track.append(")"));
        track.deleteCharAt(track.length()-1);
        //尝试去放一个左括号
        backtrack(right,left-1,track.append("("));
        track.deleteCharAt(track.length()-1);
    }


}
