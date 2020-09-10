package com.van.leetcode.other;

import javax.print.attribute.standard.PresentationDirection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思想：
 * dfs这里的判断很重要，以及visited，都是先去放，放入的时候不去做判断（不去考虑这个是否越界，或者是否visited），放完之后都利用dfs的第一个判断来筛选。
 * 还有这里的回溯，都是先做标记，然后回溯，再去撤回标记，这里的回溯可以是多个（比如这里一次性放了4个进去（上下左右））
 */
public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        //把每一个点都作为起点放进去
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (dfs(board,i,j,word,0)){
                   return true;
               }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int index) {
        //如果越界或者不匹配就返回false
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        //来到这里就代表已经匹配到了
        if (index == word.length() - 1) {
            return true;
        }
        char temp=board[x][y];
        board[x][y] = '\0';
        if (dfs(board, x + 1, y, word, index + 1)
                || dfs(board, x - 1, y, word, index + 1)
                || dfs(board, x, y + 1, word, index + 1)
                || dfs(board, x, y - 1, word, index + 1)) {
            return true;
        }
        board[x][y]=temp;
        return false;
    }

}
