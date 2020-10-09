package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] point = new int[2];
        point[0] = 0;
        point[1] = 0;
        queue.offer(point);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (temp[0] >= 0 && temp[0] < n && temp[1] >= 0 && temp[1] < m && !visited[temp[0]][temp[1]]) {
                    visited[temp[0]][temp[1]] = true;
                    res++;
                    int[] up = new int[] {temp[0] + 1, temp[1]};
                    int[] down = new int[] {temp[0] - 1, temp[1]};
                    int[] left = new int[] {temp[0], temp[1] - 1};
                    int[] right = new int[] {temp[0], temp[1] + 1};
                    queue.offer(up);
                    queue.offer(down);
                    queue.offer(left);
                    queue.offer(right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean[] a = new boolean[3];
        System.out.println(a[1]);
    }

}
