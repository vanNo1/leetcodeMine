package com.van.leetcode.caculator;

import java.util.Stack;

public class CaculatorHard {
  public  int calculate(String s) {
        int begin = 0;
        return calHelper(s, begin);

    }
   public int calHelper(String s, int i) //i用于记录计算开始的索引
    {
        char operation = '+';
        Stack<Integer>nums=new Stack<>();
        int num = 0;
        int res = 0;
        for (; i < s.length(); i++)
        {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (s.charAt(i) == '(')
            {
                num = calHelper(s, ++ i); //从i的下一个开始计算， 进入递归
                continue;
//                i++; //计算完之后的i指向)所以再++
            }
            if (((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' ') || i >= s.length() - 1) // 继续计算
            {
                int pre = 0;
                switch (operation)
                {
                    case '+': nums.push(num);
                        break;
                    case '-': nums.push(-num);
                        break;
                    case '*':
                        pre = nums.pop();
                        nums.push(pre * num);
                        break;
                    case '/':
                        pre = nums.pop();
                        nums.push(pre / num);
                        break;
                }

                operation = s.charAt(i);
                num = 0;
            }
            if (s.charAt(i) == ')') //遇到)回到上一级递归
            {
                break;
            }
        }
        while (!nums.empty())
        {
            res += nums.pop();
        }
        return res;
    }

}
