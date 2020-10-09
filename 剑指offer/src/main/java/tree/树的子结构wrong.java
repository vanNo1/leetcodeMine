package tree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

 B是A的子结构， 即 A中有出现和B相同的结构和节点值。

 例如:
 给定的树 A:

      3
     / \
    4   5
   / \
  1   2
 给定的树 B：

    4 
   /
  1
 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 这个做法的话是判断B树是否是A树的一个树枝（一定到叶子节点），isTheSame函数就是判断两棵树是否完全相同
 * 在主函数内，就是不断去寻找B树是否等于A树
 * 但这个做法是错误的，因为我要找的是B树是否是A树的一部分，B树不一定要是A树的一个树枝，它可能是A树的中间一部分而已
 */
public class 树的子结构wrong {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null||A==null){
            return false;
        }
        if (isTheSame(A,B)){
            return true;
        }else {
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
    }

    public boolean isTheSame(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A==null||B==null) {
            return false;
        }
        if (A.val==B.val){
            return isSubStructure(A.left,B.left)&&isSubStructure(A.right,B.right);
        }else {
            return false;
        }
    }
}
