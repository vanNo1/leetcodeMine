package recent.other;

import java.util.Arrays;

/**
 * @author Van
 * @date 2021/3/7 - 9:27
 *
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * 输出: -1
 *
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 题解：
 * https://leetcode-cn.com/problems/gas-station/solution/134-jia-you-zhan-tan-xin-jing-dian-ti-mu-xiang-jie/
 *
 * 1.如果总油大于cost总油那么就一定可以跑完，否则一定跑不完
 * 2.由于题目有唯一解，如果能跑完的话，有且只有一个起点能够让它跑完
 * 所以后面的for循环中遍历了所以起点，如果中途remain<0了那么这个起点直接为i+1，不用考虑[起点,i]这个区间的点，
 * 因为从那个区间任意点出发都到达不了。
 *
 * 最小case用：
 *          remain：      +
 *                       (2)
 *                     -------
 *                     \      \
 *               (1) - \      \ + (3)
 *                     \------\
 *                      (0) -
 *                      这个case：从index=2 出发；
 */
public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[gas.length];
        for (int i = 0; i < remain.length; i++) {
            remain[i] = gas[i] - cost[i];
        }
        int total = 0;
        int index=0;
        int surplus=0;
        for (int i = 0; i < remain.length; i++) {
            total += remain[i];
            surplus+=remain[i];
            if (surplus<0){
                index=i+1;
                surplus=0;
            }
        }
        if (total < 0) return -1;
        return index;
    }
}
