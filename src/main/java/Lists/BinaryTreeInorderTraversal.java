package Lists;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium 94. Binary Tree Inorder Traversal
 * @author: dekai.kong
 * @date: 2019-01-08 11:22
 * @from https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * TODO 二叉树遍历 多刷
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 *
 * 层次遍历：只需按层次遍历即可
 * 可参考 https://blog.csdn.net/My_Jobs/article/details/43451187
 */

public class BinaryTreeInorderTraversal {
    public BinaryTreeInorderTraversal() {

    }

    /**
     * Runtime: 1 ms, faster than 63.40% of Java online submissions for Binary Tree Inorder Traversal.
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list,root);
        return list;
    }
    public void helper(List<Integer> list,TreeNode root){
        if(root!=null){
            helper(list,root.left);
            list.add(root.val);
            helper(list,root.right);
        }
    }

    /**
     *
     * 非递归法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list,root);
        return list;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;
        System.out.println(inorderTraversal(root));
    }
}

