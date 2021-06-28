package recent.tree;

/**
 * @author Van
 * @date 2021/3/20 - 10:36
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 这道题直接利用递归后续遍历来解决！
 * 主要思想：先序遍历的话h我要让它的left=null，right=pre，但后面递归的时候会影响right指针。
 * 所以从后续遍历：后续遍历其实已经遍历完了，后面再进行松弛操作。而且这里进行了改造，设想1，2，3节点的一棵树，
 * 先序遍历是1，2，3 那么普通的后续遍历是2，3，1，所以进行改造，让它变成3，2，1：右左根
 *
 */
public class 二叉树展开为链表 {
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }
}
