package Void;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 描述 Hard Recover Binary Search Tree
 * @author: dekai.kong
 * @date: 2019-02-01 14:24
 * @from https://leetcode.com/problems/recover-binary-search-tree/
 * 99. Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 * follow up O(1)的空间复杂度可以用morris遍历
 * https://blog.csdn.net/zjucor/article/details/72898494
 * //TODO 待完成
 */

public class RecoverBinarySearchTree {
    public RecoverBinarySearchTree() {

    }

    /**
     * Runtime: 28 ms, faster than 41.42% of Java online submissions for Recover Binary Search Tree.
     * @param root
     * 使用中序遍历 (前 中 后)遍历所有的节点及值
     * 排序值,赋值给list即可
     * space O(n)
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        helper(root,list,vals);
        Collections.sort(vals);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = vals.get(i);
        }
    }
    public void helper(TreeNode root, List list,List<Integer> vals){
        if(root!=null){
            helper(root.left,list,vals);
            list.add(root);
            vals.add(root.val);
            helper(root.right,list,vals);
        }
    }

    @Test
    public void test() {
        TreeNode p = new TreeNode(1);
        p.left = null;
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        p.right = right;
        recoverTree(p);
    }
}

