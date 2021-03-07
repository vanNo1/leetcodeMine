package recent.graph;

/**
 * @author Van
 * @date 2021/3/7 - 18:06
 * <p>
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * graph就是dp数组：
 * graph[i][j] 表示：从i点到j点的最短路径
 */
public class 网络延迟时间 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 别设置为Integer.MAXVALUE 否则相加的时候溢出，导致小于0了
        int inf = 999;
        int[][] graph = new int[n + 1][n + 1];
        // 初始化，这是个有向图
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = inf;
                }
            }
        }
        // 赋初值
        for (int[] time : times) {
            int src = time[0];
            int des = time[1];
            int wight = time[2];
            graph[src][des] = wight;
        }
        // 经典三循环。直接在graph中原地修改
        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][m] + graph[m][j]) {
                        graph[i][j] = graph[i][m] + graph[m][j];
                    }
                }
            }
        }
        // 看看到达了几个点
        int count = 0;
        //到达某个点最大的时间
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            if (graph[k][i] != inf) {
                count++;
                max = Math.max(max, graph[k][i]);
            }
        }
        // 如果到达了所有点，那么就输出最大时间，否则输出-1
        if (count == n - 1) {
            return max;
        } else {
            return -1;
        }
    }
}
