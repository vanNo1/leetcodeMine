package com.van.leetcode.other;

/**
 * recurse 含义：这棵树的最小深度
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
