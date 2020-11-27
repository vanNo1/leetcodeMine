package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：二叉搜索树的中序遍历是一个升序序列！
 */
public class 验证二叉搜索树 {
    private List<Integer> traversal=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        int[] arrays = traversal.stream().mapToInt(Integer::valueOf).toArray();
        // 判断是否是一个升序序列
        for (int i = 0; i < arrays.length-1; i++) {
            if (arrays[i+1]<=arrays[i]){
                return false;
            }
        }
        return true;
    }

    // 直接递归把val塞入traversal中
    public void inOrderTraversal(TreeNode root) {
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        traversal.add(root.val);
        inOrderTraversal(root.right);
    }

}
