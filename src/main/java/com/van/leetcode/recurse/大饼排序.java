package com.van.leetcode.recurse;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 大饼排序 {
    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> pancakeSort(int[] A) {
        recurse(A, A.length - 1);
        return result;
    }

    //从arr的【0，end】这部分去递归
    public static void recurse(int[] arr, int end) {
        if (end == 0) {
            return;
        }
        int maxPancake = 0;
        int maxPancakeIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > maxPancake) {
                maxPancake = arr[i];
                maxPancakeIndex = i;
            }
        }
        reverse(arr, 0, maxPancakeIndex);
        result.add(maxPancakeIndex + 1);
        reverse(arr, 0, end);
        result.add(end + 1);
        recurse(arr, end - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        int i = 0, j = end;
        if (end >= arr.length) {
            return;
        }
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};
        reverse(arr, 0, arr.length - 2);
        System.out.println(arr);
    }
}
