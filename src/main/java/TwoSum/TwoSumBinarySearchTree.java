package TwoSum;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-06 18:06
 */

/**
 * LeetCode
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 * 使用递归遍历所有树节点,然后相加为k的话就返回为true 不是的话就把当前节点的值加入到set
 */
public class TwoSumBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean findTarget(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root,int k,Set set){
        if(root == null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return find(root.left,k,set) || find(root.right,k,set);
    }
}
