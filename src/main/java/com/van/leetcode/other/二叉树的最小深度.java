package com.van.leetcode.other;

/**
 * recurse 含义：这棵树的最小深度
 *
 * 它是根节点到叶子节点的个数
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * 这道题如果按照最大深度的模板来写最小深度会错误，如果根节点它是只有左孩子的，呢么min函数的时候，直接返回1了
 * 所以要避免这种情况出现，也就是说如果一个节点只有一个孩子的时候，不能让他recurse(空孩子)
 */
public class 二叉树的最小深度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        return recurse(root);
    }
        public int recurse(TreeNode treeNode){
            if (treeNode==null){
                return 0;
            }
            if (treeNode.left==null&&treeNode.right==null){
                return 1;
            }
            // 不能让他recurse空孩子
            if (treeNode.right==null||treeNode.left==null){
                if (treeNode.right==null){
                   return recurse(treeNode.left)+1;
                }else {
                   return recurse(treeNode.right)+1;
                }
            }else {
                return Math.min(recurse(treeNode.left),recurse(treeNode.right))+1;
            }
        }
}
