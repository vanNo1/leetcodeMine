package dfs;

import java.util.*;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 课程表 {
    // 节点的入度: 使用数组保存每个节点的入度,
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 将所有的课程先放入
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 2.依赖关系, 依赖当前课程的后序课程
        Map<Integer, List<Integer>> adj = new HashMap<>();



        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            // (3,0), 想学3号课程要先完成0号课程, 更新3号课程的入度和0号课程的依赖(邻接表)
            int cur = relate[1];
            int next = relate[0];
            // 1.更新入度
            inDegree.put(next, inDegree.get(next) + 1);
            // 2.当前节点的邻接表
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<>());
            }
            adj.get(cur).add(next);
        }

        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }

        // 4.遍历入队, 如果还有课程的入度不为0, 返回fasle
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;

    }


}
