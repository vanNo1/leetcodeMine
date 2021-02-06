package backtrack;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Van
 * @date 2021/1/30 - 11:10
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * add多少次就撤销多少次：这里add了一次，所以对应的就撤销一次即可
 */
public class 二叉树中和为某一值的路径 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        backtrack(root, sum, new ArrayList<>());
        return result;
    }

    public void backtrack(TreeNode root, int sum, List<Integer> track) {
        if (root == null) {
            return;
        }
        track.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(track));
            }
            // 这里不能放return！！！！
//            return;
        }
        backtrack(root.left, sum, track);
        backtrack(root.right, sum, track);
        sum += root.val;
        track.remove(track.size() - 1);
    }
}
