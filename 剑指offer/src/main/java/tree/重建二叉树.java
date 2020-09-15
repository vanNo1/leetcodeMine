package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 理解：
 * 递归的主要思想是在中序遍历上。在中序遍历数组中每次取出root制造root，然后给left和right赋值。
 * 每一个left，right又来一次recurse
 *
 */
public class 重建二叉树 {
    //这个数组等于preorder数组，目的是让recurse函数可以使用
    private int[] p;
    //把中序遍历数组中的值存入map中
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recurse(0,0,inorder.length-1);

    }

    /**
     * @param preRoot root节点在preorder数组中的index
     * @param inLeft 中序遍历数组中左树的边界
     * @param inRight 右树的边界（后）
     * @return
     */
    public TreeNode recurse(int preRoot, int inLeft, int inRight) {
        if (inLeft>inRight){
            return null;
        }
        int rootValue=p[preRoot];
        TreeNode root=new TreeNode(rootValue);
        int inRootIndex=map.get(rootValue);
        root.left=recurse(preRoot+1,inLeft,inRootIndex-1);
        root.right=recurse(preRoot+inRootIndex-inLeft+1,inRootIndex+1,inRight);
        return root;
    }


}
