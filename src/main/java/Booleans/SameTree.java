package Booleans;

import Entitys.TreeNode;
import org.junit.Test;

/**
 * @description: 描述 Easy  Same Tree
 * @author: dekai.kong
 * @date: 2019-01-29 14:01
 * @from https://leetcode.com/problems/same-tree/
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */

public class SameTree {
    public SameTree() {

    }

    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Same Tree.
     * @param p
     * @param q
     * @return
     * 递归 前序遍历
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
    public boolean helper(TreeNode p, TreeNode q){
        if(p!=null && q!=null){
            boolean a = p.val==q.val;
            if(!a) return false;
            boolean b = helper(p.left,q.left);
            if(!b) return false;
            boolean c = helper(p.right,q.right);
            if(!c) return false;
            if(a && b && c) return true;
        }else if(p==q) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        TreeNode p = new TreeNode(1);
        p.left = null;
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        p.right = right;

        TreeNode q = new TreeNode(1);
        q.left = null;
        TreeNode rightq = new TreeNode(2);
        rightq.left = new TreeNode(3);
        q.right = rightq;

        System.out.println(isSameTree(p,q));
    }
}

