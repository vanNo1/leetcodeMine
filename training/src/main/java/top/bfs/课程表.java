package top.bfs;

import java.util.*;

/**
 * @author Van
 * @date 2021/2/10 - 15:35
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 是用到了两个map一个queue
 * 并且入度的map每一个课程的入度都要装进去！！！
 */
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            inDegree.put(course, 0);
        }
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            inDegree.put(cur, inDegree.get(cur) + 1);
            if (!adj.containsKey(pre)) {
                adj.put(pre, new ArrayList<>());
            }
            adj.get(pre).add(cur);
        }
        inDegree.forEach((key, value) -> {
            if (value == 0) {
                queue.offer(key);
            }
        });
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int courseZero = queue.poll();
                List<Integer> list = adj.get(courseZero);
                if (list == null) {
                    continue;
                }
                list.forEach(course -> {
                    inDegree.put(course, inDegree.get(course) - 1);
                    if (inDegree.get(course) == 0) {
                        queue.offer(course);
                    }
                });
            }
        }
        for (int course : inDegree.keySet()) {
            if (inDegree.get(course)!=0){
                return false;
            }
        }
        return true;
    }
}
