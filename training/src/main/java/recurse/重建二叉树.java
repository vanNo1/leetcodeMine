package recurse;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Van
 * @date 2021/2/2 - 11:43
 *
 * 之前分不清左右边界应该取中序遍历的还是前序遍历
 * 提一个问题就知道痛点了：第一次前序遍历中的root节点就是第0个，第个root节点是第1个，那么第三个root节点是第几个？
 * 这个就要用到中序遍历来决定了，用中序遍历的左边界和rootIndex得到这段长度，然后在前序遍历中用上
 */
public class 重建二叉树 {
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recurse(preorder, 0, 0, inorder.length - 1);
    }

    public TreeNode recurse(int[] preorder, int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preRoot]);
        Integer inorderRootIndex = inorderMap.get(root.val);
        root.left = recurse(preorder, preRoot + 1, inLeft, inorderRootIndex - 1);
        root.right = recurse(preorder, preRoot + inorderRootIndex - inLeft + 1, inorderRootIndex + 1, inRight);
        return root;
    }
}
