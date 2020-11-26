package bfs;

import java.util.*;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：有点长：看这个：https://leetcode-cn.com/problems/course-schedule/solution/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/
 * 总体来说：
 * 想象成一个有向图，把入度为0 的课程装入队列，消费课程的时候把它连接的课程的入度给减一，入过为0了就再装入队列，这样循环
 * 最后的话正常情况下是所有的课程入度都会是0
 *
 */
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 课程与它的入度
        Map<Integer, Integer> course2InDegree = new HashMap<>();
        // 课程与它的先决课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // bfs 需要的队列
        Queue<Integer> queue = new LinkedList<>();
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
                    }
                }

            }
        }
        // 正常情况下最后的课程应该入度都是0了
        for (int course : course2InDegree.keySet()) {
            // 非正常情况
            if (course2InDegree.get(course) != 0) {
                return false;
            }
        }

        return true;
    }
}
