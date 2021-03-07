package recent.tree;

/**
 * @author Van
 * @date 2021/3/1 - 20:49
 */
public class 二叉搜索树中第K小的元素 {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        recurse(root, k);
        return result;
    }

    public void recurse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        recurse(root.left, k);
        if (++count == k) {
            result = root.val;
        }
        recurse(root.right, k);
    }
}
