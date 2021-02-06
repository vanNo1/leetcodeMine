package recurse;

import structure.TreeNode;

/**
 * @author Van
 * @date 2021/2/2 - 10:35
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 失误：这里写成了都等于null！应该是都不等于null才对，左右都有值的情况下我才要去返回头节点（root）
        if (left != null && right != null) {
            return root;
        }
        // 到了这里：一个有值，一个无值，那么直接返回有值的即可
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
