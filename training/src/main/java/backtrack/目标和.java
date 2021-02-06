package backtrack;

/**
 * @author Van
 * @date 2021/1/29 - 10:31
 * <p>
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 *
 * 把之前的模型再丰富一下：
 * 已知：退出条件一般都是靠判断track的容量
 * 假设只有两层结构，父节点和下面的两个节点：
 * 一开始在父结点：
 * 现在往下面吞一个左孩子节点：还没开始吞，就要先判断一下此时的track容量（track容量没问题）此时开始吞左孩子节点
 * 吞完了左孩子节点此时容量已满。现在接着往下面再吞，还没开始吞就又要先判断track容量（此时track容量已满）于是退出
 * 现在又回到了左孩子节点。现在撤销选择，把左孩子节点吐出，于是又回到了父节点。现在以同样的方式来吞右孩子节点。。。
 *
 * 总的来说比之前的模型多了一个判断（这个判断是在往下吞之前触发的）！
 *
 * 而这道题，我用的是index作为容量判断。用这个模型可以看出，index在水平方向没有变过，而一般的track模型一上一下的水平过程
 * 中是会变化的，但仔细研究可以发现，index不变化根本无所谓的！只要往下是+1的就行。
 */
public class 目标和 {
    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, 0, 0, S);
        return result;
    }

    public void backtrack(int[] nums, int index, int track, int S) {
        if (index == nums.length) {
            if (track == S) {
                result++;
            }
            return;
        }
        track += nums[index];
        // 这里+1 就行
        backtrack(nums, index + 1, track, S);
        // 撤销选择的时候不用撤销index，index保持水平不变就行，不影响的！
        track -= nums[index];

        track -= nums[index];
        backtrack(nums, index + 1, track, S);
        track += nums[index];
    }

}
