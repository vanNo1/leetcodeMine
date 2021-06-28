package com.van.skill;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Van
 * @date 2021/3/13 - 19:25
 */
public class map排序 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey());
        map.entrySet().stream().sorted(Map.Entry.comparingByValue());

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }
}
