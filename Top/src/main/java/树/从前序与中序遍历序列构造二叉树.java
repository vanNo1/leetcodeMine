package 树;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  *
 *  *  
 *  *
 *  * 例如，给出
 *  *
 *  * 前序遍历 preorder = [3,9,20,15,7]
 *  * 中序遍历 inorder = [9,3,15,20,7]
 *  * 返回如下的二叉树：
 *  *
 *  *     3
 *  *    / \
 *  *   9  20
 *  *     /  \
 *  *    15   7
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  *
 *  * 理解：
 *  * 递归的主要思想是在中序遍历上。在中序遍历数组中每次取出root制造root，然后给left和right赋值。
 *  * 每一个left，right又来一次recurse
 */
public class 从前序与中序遍历序列构造二叉树 {
        private Map<Integer, Integer> inMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return constructTree(preorder,0,0,inorder.length-1);
        }

        public TreeNode constructTree(int[] preorder, int preRootIndex, int inLeft, int inRight) {
            if (inLeft > inRight) {
                return null;
            }
            int rootValue = preorder[preRootIndex];
            TreeNode root=new TreeNode(rootValue);
            Integer inRootIndex = inMap.get(rootValue);
            root.left=constructTree(preorder,preRootIndex+1,inLeft,inRootIndex-1);
            root.right=constructTree(preorder,preRootIndex+inRootIndex-inLeft+1,inRootIndex+1,inRight);
            return root;
        }



}
