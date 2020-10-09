package tree;

public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return twoTreeSymmetric(root.left,root.right);
    }
    public boolean twoTreeSymmetric(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null){
            return true;
        }
        if (root1==null||root2==null){
            return false;
        }
        if (root1.val==root2.val){
            return twoTreeSymmetric(root1.left,root2.right)&&twoTreeSymmetric(root1.right,root2.left);
        }else {
            return false;
        }
    }
}
