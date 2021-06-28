package com.van.skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Van
 * @date 2021/3/13 - 19:23
 */
public class 最大值最小值 {
    public static void main(String[] args) {
        // Integer类型要转换成int类型，然后才能用max()
        List<Integer> list = new ArrayList<>();
        list.stream().mapToInt(Integer::intValue).max().getAsInt();
        // int 类型可以直接用max()
        int[] array = new int[2];
        Arrays.stream(array).max().getAsInt();
        // 打印：
        list.stream().forEach(System.out::println);
    }
}
