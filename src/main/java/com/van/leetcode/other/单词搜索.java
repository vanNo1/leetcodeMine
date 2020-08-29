package com.van.leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int[][] visit = new int[board.length][board[0].length];
        Queue<Integer[]> queue = new LinkedList();
        int step = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    queue.offer(new Integer[] {i, j});
                    visit[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] container = queue.poll();
                int ii=container[0];
                int jj=container[1];

            }
        }
    }

    public boolean isValidate(int i, int j, int len, int width) {
        if (i >= 0 && i < width && j >= 0 && j < len) {
            return true;
        } else {
            return false;
        }
    }
}
