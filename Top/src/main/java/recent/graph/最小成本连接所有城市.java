package recent.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Van
 * @date 2021/3/7 - 16:03
 *
 * 想象一下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。
 *
 * 给你一些可连接的选项 conections，其中每个选项 conections[i] = [city1, city2, cost] 表示将城市 city1 和城市 city2 连接所要的成本。（连接是双向的，也就是说城市 city1 和城市 city2 相连也同样意味着城市 city2 和城市 city1 相连）。
 *
 * 返回使得每对城市间都存在将它们连接在一起的连通路径（可能长度为 1 的）最小成本。
 *  该最小成本应该是所用全部连接代价的综合。如果根据已知条件无法完成该项任务，则请你返回 -1。
 *
 * 示例 1：
 *
 *
 *
 * 输入：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
 * 输出：6
 * 解释：
 * 选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
 * 示例 2：
 *
 *
 *
 * 输入：N = 4, conections = [[1,2,3],[3,4,4]]
 * 输出：-1
 * 解释：
 * 即使连通所有的边，也无法连接所有城市。
 *
 * 提示：
 * 1 <= N <= 10000
 * 1 <= conections.length <= 10000
 * 1 <= conections[i][0], conections[i][1] <= N
 * 0 <= conections[i][2] <= 10^5
 * conections[i][0] != conections[i][1]
 */
public class 最小成本连接所有城市 {
    public int minimumCost(int N, int[][] connections) {
        // sort connections by cost from small to large
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        List<Integer> cost = new ArrayList<>();
        //[1,N]N个点，他们连接的情况
        int[] parent = new int[N + 1];
        //一开始设置为自己连接着自己！
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
        }
        // 遍历所有的边，其中有能连接的和不能连接的
        for (int[] edge : connections) {
            if (union(edge[0], edge[1], parent)) {
                cost.add(edge[2]);
                // 只要边达到N-1就可退出，因为连接N个点只要N-1条边，那么有N-1个不连通的边，必定连接了N个点
                if (cost.size()==N-1) break;
            }
        }
        // 当然也有可能出现边不足的情况，那么这个时候不能连通！
        if (cost.size() != N - 1) {
            return -1;
        } else {
            return cost.stream().reduce(0, (o1, o2) -> o1 + o2);
        }
    }

    // 这个叫做并查集
    //找到root点，只有root点是自己连接着自己的！
    public int findRoot(int v, int[] parent) {
        if (v == parent[v]) return v;
        return findRoot(parent[v], parent);
    }


    // 把两个点连接在一起
    public boolean union(int a, int b, int[] parent) {
        int rootA = findRoot(a, parent);
        int rootB = findRoot(b, parent);
        // 如果两个点的root点相同，说明他们已经是一条线上的点
        if (rootA == rootB) return false;
        // 否则连接这两个点
        parent[a] = b;
        return true;
    }
}
