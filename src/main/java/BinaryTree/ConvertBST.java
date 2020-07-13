package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 16:03
 * @from 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *  
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路 中序遍历 进行累加
 **/
public class ConvertBST {
    public ConvertBST() {

    }

    /**
     * 方法1
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 18.62%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 80.00%
     * 的用户
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return root;
        }
        List<TreeNode> ls = new ArrayList<>();
        List<Integer> lsv = new ArrayList<>();
        helper2( root,  ls,lsv);

        for (int i = 0; i < ls.size(); i++) {
            int val = lsv.get(i);
            ls.get(i).val=val;
        }
        return root;
    }
    int val = 0;
    public void helper(TreeNode root, List<TreeNode> ls,List<Integer> lsv){
        if (root != null) {
            helper( root.left,  ls,lsv);
            ls.add(root);
            lsv.add(root.val);
            helper(root.right,ls,lsv);
        }
    }


    public void helper2(TreeNode root, List<TreeNode> ls,List<Integer> lsv){
        if (root != null) {
            helper2(root.right,ls,lsv);
            ls.add(root);
            val+=root.val;
            lsv.add(val);
            helper2( root.left,ls,lsv);
        }
    }
    /**
     * 直接后续遍历试试
     * @param root
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.35%
     * 的用户
     * 内存消耗：
     * 40.2 MB
     * , 在所有 Java 提交中击败了
     * 73.33%
     * 的用户
     */

    public void helper(TreeNode root){
        if (root != null) {
            helper(root.right);
            val+=root.val;
            root.val = val;
            helper( root.left);
        }
    }

    @Test
    public void test() {
        TreeNode tn = new TreeNode(5);
        tn.left = new TreeNode(2);
//        tn.left.left = new TreeNode(1);
//        tn.left.right = new TreeNode(3);
        tn.right = new TreeNode(13);
        convertBST(tn);
//        helper(tn);
    }
}
