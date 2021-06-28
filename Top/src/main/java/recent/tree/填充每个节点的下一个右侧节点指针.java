package recent.tree;

/**
 * @author Van
 * @date 2021/3/8 - 15:30
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * curseConnect其实就是递归的连接root1 和 root2每次连接一下
 */
public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) return root;
        root.next = null;
        curseConnect(root.left, root.right);
        return root;
    }

    public void curseConnect(Node root1, Node root2) {
        if (root1 == null || root2 == null) return;
        root1.next = root2;
        curseConnect(root1.left, root1.right);
        curseConnect(root2.left, root2.right);
        curseConnect(root1.right, root2.left);
    }
}
