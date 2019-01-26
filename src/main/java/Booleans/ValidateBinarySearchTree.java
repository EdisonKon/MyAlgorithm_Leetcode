package Booleans;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium Validate Binary Search Tree
 * @author: dekai.kong
 * @date: 2019-01-26 16:09
 * @from https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */

public class ValidateBinarySearchTree {
    public ValidateBinarySearchTree() {

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }

    /**
     * 解法2 利用中序遍历
     * @param root
     * @return
     * 递归过程中换成它们自己的节点值，用long代替int就是为了包括int的边界条件
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    @Test
    public void test() {

    }
}

