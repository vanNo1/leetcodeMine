package top.bfs;

import java.util.*;

/**
 * @author Van
 * @date 2021/2/11 - 10:51
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 *  
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 失误！！！我这里忘记加visited数组了！不加的话会有死循环的！！！
 */
public class 单词接龙 {
    Queue<String> queue = new LinkedList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        int count = 1;
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        put(beginWord.toCharArray(), wordSet, visited);
        count++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (endWord.equals(poll)) {
                    return count;
                }
                put(poll.toCharArray(), wordSet, visited);
            }
            count++;
        }
        return 0;
    }

    public void put(char[] word, Set<String> wordSet, Set<String> visited) {
        for (int i = 0; i < word.length; i++) {
            char origin = word[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (origin == j) {
                    continue;
                }
                word[i] = j;
                String changedWord = String.valueOf(word);
                if (wordSet.contains(changedWord)) {
                    if (!visited.contains(changedWord)) {
                        queue.offer(changedWord);
                        // 失误：这里忘记写了
                        visited.add(changedWord);
                    }
                }
            }
            // 失误: 忘记变回来了
            word[i] = origin;
        }
    }

}
