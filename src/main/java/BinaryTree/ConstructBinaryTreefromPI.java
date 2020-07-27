package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-13 09:51
 * @from 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    结题思路,前序遍历的数组第一个值肯定是root,找到这个root在中序遍历的位置,那么root左边的数组就是左子树
 *    再进行递归
 *    当前序遍历数组与中序遍历数组的元素相同的时候,那么可以知道这个节点是一个子树的root
 **/
public class ConstructBinaryTreefromPI {
    public ConstructBinaryTreefromPI() {

    }

    /**
     *  preorder = [3,9,20,15,7]
     *  inorder = [9,3,15,20,7]
     *
     *  Runtime: 6 ms, faster than 19.39% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 39.7 MB, less than 68.19% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return treeNode;
    }

    public TreeNode helper(int[] preorder, int[] inorder,int pl,int pr,int il,int ir){
        if (pl > pr || il > ir) return null;
        int i = 0;
        for (i = il; i < ir; i++) {
            if(inorder[i]==preorder[pl]){
                break;
            }
        }
        TreeNode treeNode = new TreeNode(preorder[pl]);
        treeNode.left = helper(preorder,inorder,pl+1,pl+i-il,il,i-1);
        treeNode.right = helper(preorder,inorder,pl+i-il+1,pr,i+1,ir);

        return treeNode;
    }

    @Test
    public void test() {
//        TreeNode treeNode = buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        TreeNode treeNode = buildTree2(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

    /**
     * 练习构建树 并且输出后序遍历
     * 剑指 Offer 07. 重建二叉树
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
     * @param pre
     * @param mid
     * @return
     */
    public TreeNode buildTree2(int[] pre,int[] mid){
        return helper2(pre,mid,0,pre.length-1,0,mid.length-1);
    }

    public TreeNode helper2(int[] pre,int[] mid,int pl,int pr,int ml,int mr){
        if(pl>pr || ml>mr){
            return null;
        }
        int i = ml;
        for (; i < mr; i++) {
            if(mid[i] == pre[pl]){
                break;
            }
        }

        TreeNode treeNode = new TreeNode(pre[pl]);
        treeNode.left = helper2(pre, mid, pl+1, pl+i-ml, ml, i-1);
        treeNode.right = helper2(pre, mid, pl+i-ml+1, pr, i+1, mr);

        System.out.println(treeNode.val);
        return treeNode;
    }
}
