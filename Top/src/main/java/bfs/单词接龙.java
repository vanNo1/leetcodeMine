package bfs;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：
 * bfs， 每次去调currentWord的一个字符，如果在wordList中那么就放入queue，每一轮queue中的数值代表的是currentWord改变一个字符之后的并且在wordList中的String
 *
 * bfs相比dfs的好处是可以提前结束循环，因为它本身就是从小扩散到大，而dfs要遍历每一条路，所以这道题用dfs会超时
 */
public class 单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //这里很坑，不能用List的contain，否则会超时，得改为set的contain，因为它的复杂度是o（1），List是o（n）
        Set<String>wordSet=new HashSet<>(wordList);
        //如果根本就没有endWord直接返回0
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String>visited=new HashSet<>();
        visited.add(beginWord);
        // 初始就为1，因为题目意思是要加上原本组成的链路的长度
        int step = 1;
        //标准的一套bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (changeEveryOneLetter(currentWord, endWord, wordSet, queue,visited)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     *
     * @param currentWord
     * @param endWord
     * @param wordSet
     * @param queue
     * @param visited
     * @return
     * 作用是：找到currentWord仅改动一个字符得到的在workList中的字符，并且放入queue and visited，如果此字符正好等于endWord那么返回true否则false
     */
    private boolean changeEveryOneLetter(String currentWord, String endWord, Set<String> wordSet, Queue<String> queue,Set<String>visited) {
        // 轮训currentWord的每一个字符，依次改动currentWord的每一个字符
        for (int i = 0; i < currentWord.length(); i++) {
            char originChar = currentWord.charAt(i);
            // 从a到z依次改动
            for (char c = 'a'; c <= 'z'; c++) {
                //原本的就不要了
                if (c==originChar){
                    continue;
                }
                char[] chars = currentWord.toCharArray();
                chars[i]=c;
                String changedWord=String.valueOf(chars);
                if (wordSet.contains(changedWord)){
                    if (changedWord.equals(endWord)){
                        return true;
                    }
                    // 来到这里说明不等于endWord
                    if (!visited.contains(changedWord)){
                        queue.add(changedWord);
                        // 一定要记得加入visited否则死循环
                        visited.add(changedWord);
                    }
                }
            }

        }
        return false;
    }

}
