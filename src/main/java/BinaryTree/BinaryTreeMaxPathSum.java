package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult hard
 * @create 2020-07-12 20:41
 * @from 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 *
 **/
public class BinaryTreeMaxPathSum {

    public BinaryTreeMaxPathSum() {

    }

    /**
     * 执行结果： 通过
     * 显示详情 执行用时： 1 ms , 在所有 Java 提交中击败了 99.79% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 7.69% 的用户
     */

    // -10,9,20,null,null,15,7
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSaidCul(root);
        return ans;
    }

    public int oneSaidCul(TreeNode root){
        if(root==null) {return 0;}
        int left = Math.max(0,oneSaidCul(root.left));
        int right = Math.max(0,oneSaidCul(root.right));
        ans = Math.max(ans,left+right+root.val);
        return Math.max(left,right)+root.val;
    }

    @Test
    public void test() {
        TreeNode treeNode = genTreeNode(new int[]{-10,9,20,0,0,15,7},0);
        System.out.println(maxPathSum(treeNode));
    }

    public TreeNode genTreeNode(int[] ints,int index){
        TreeNode temp = new TreeNode();
        if(ints[index]==0){
            return null;
        }else{
            temp.val = ints[index];
            if(2*index+1<ints.length){
                temp.left = genTreeNode(ints,2*index+1);
                temp.right = genTreeNode(ints,2*index+2);
            }
        }
        return temp;
    }
}
