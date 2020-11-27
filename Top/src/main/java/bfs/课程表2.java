package bfs;

import java.util.*;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 与课程表1相比，只不过是把每次加入到queue中的course再加入到result中即可
 */
public class 课程表2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 课程与它的入度
        Map<Integer, Integer> course2InDegree = new HashMap<>();
        // 课程与它的先决课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // bfs 需要的队列
        Queue<Integer> queue = new LinkedList<>();
        //result
        List<Integer> result = new ArrayList<>();
        // 先初始化，把每个课程的入度都设置为0
        for (int i = 0; i < numCourses; i++) {
            course2InDegree.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            // cur代表需要学习的课程
            int cur = prerequisite[0];
            // next代表cur课程的先决课程
            int next = prerequisite[1];
            // 给cur增加入度
            course2InDegree.put(cur, course2InDegree.get(cur) + 1);
            // 注意这里不要放反了，是next 连着cur，因为去掉next课程后需要找到它连着的课程，把这个课程的入度给减一
            if (!adj.containsKey(next)) {
                adj.put(next, new ArrayList<>());
            }
            adj.get(next).add(cur);
        }


        // 初始阶段队列中放入入度为0的课程，可以直接学习
        for (int course : course2InDegree.keySet()) {
            int inDegree = course2InDegree.get(course);
            if (inDegree == 0) {
                queue.offer(course);
                //todo 将queue中的course放入result即可
                result.add(course);
            }
        }

        //经典bfs框架
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 队列中装的都是入度为0的课程
                int courseInDegreeZero = queue.poll();
                // 这一步一定要写，不然会空指针，因为最后一门课程它后面不连接其他的课程，adj中是没有这个课程的
                if (adj.get(courseInDegreeZero) == null) {
                    continue;
                }
                // 消费掉这个课程后那么要把它连接的课程给取出来，然后将他们的入度给减一，若它入度为0那么又可以直接学习，于是放入队列
                for (int course : adj.get(courseInDegreeZero)) {
                    // 将它连接的课程的入度给减一
                    course2InDegree.put(course, course2InDegree.get(course) - 1);
                    // 如果减一过后为0，那么可以直接学习，于是装入队列
                    if (course2InDegree.get(course) == 0) {
                        queue.offer(course);
                        //todo 将queue中的course放入result即可
                        result.add(course);
                    }
                }

            }
        }
        // 正常情况下最后的课程应该入度都是0了
        for (int course : course2InDegree.keySet()) {
            // 非正常情况
            if (course2InDegree.get(course) != 0) {
                return new int[] {};

            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

}
