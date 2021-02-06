package recurse;

import structure.TreeNode;

/**
 * @author Van
 * @date 2021/2/2 - 10:55
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 这道题很有意思！双重递归！而且递归成立条件是B==null，这是最小的粒子！不能以判断B是否为叶子来做粒子判断，因为B很可能是少了左或右孩子的一个节点
 * 我一开始写的递归只是考虑了从A的root开始比较，但没有考虑缩小树范围，到这里就不会做了！
 * 其实缩小树的范围是在第一个函数里面的！用recurse判断一下从头比较起来可不可行，不行就缩小树，用左树和B比较，用右树和B比较......
 *
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recurse(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recurse(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return recurse(A.left, B.left) && recurse(A.right, B.right);
    }
}
