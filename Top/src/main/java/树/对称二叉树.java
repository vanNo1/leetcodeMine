package 树;



public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        // null也算是一个对称二叉树
        if(root==null){
            return true;
        }
        return isTwoTreeMirror(root.right,root.left);
    }
    public boolean isTwoTreeMirror(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val==root2.val){
            return isTwoTreeMirror(root1.left,root2.right)&&isTwoTreeMirror(root1.right,root2.left);
        }
        return false;
    }
}
