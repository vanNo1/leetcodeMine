package com.van.leetcode.caculator;

import java.util.Stack;

public class CaculatorMedium {
    public static int calculate(String s) {
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        Integer num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigital(c)) {
                num = num*10 + (c - '0');
            }
            if (!isDigital(c) && c != ' ' || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre/num);
                }
                sign=c;
                num=0;
            }
        }
        return sum(stack);
    }

    public static boolean isDigital(char c) {
        int i=c-'0';
        //only can be [0-9]
        if (i>=0&&i<=9){
            return true;
        }else {
            return false;
        }
    }
    public static int sum(Stack<Integer> stack){
        int sum=0;
        while (!stack.empty()){
            sum+=stack.pop();
        }
        return sum;
    }


}
