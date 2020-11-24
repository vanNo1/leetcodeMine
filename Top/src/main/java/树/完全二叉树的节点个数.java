package 树;

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        return nodeNumber(root);
    }

    public int nodeNumber(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeNumber(root.left) + nodeNumber(root.right);
    }

}
