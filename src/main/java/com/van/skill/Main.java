package com.van.skill;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/3/13 - 19:21
 */
public class Main {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.stream().mapToInt(Integer::intValue).max().getAsInt();

    }
}
