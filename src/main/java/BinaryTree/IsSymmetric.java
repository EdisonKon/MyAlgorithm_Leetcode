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
 * @create 2020-07-14 10:17
 * @from 剑指 Offer 28. 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路,从顶到下的递归,判断左节点和右节点,判断左.左 和右.右
 **/
public class IsSymmetric {
    public IsSymmetric() {

    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null || right==null||left.val != right.val){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }


    @Test
    public void test() {

        TreeNode tn = TreeNode.genTreeNode(new int[]{1,2,2,3,4,4,3},0);
        isSymmetric(tn);
    }

    public boolean testSelf(TreeNode root) {
        if(root==null){
            return true;
        }
        return helpx(root.left,root.right);
    }

    private boolean helpx(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left==null||right==null||left.left!=right.right) return false;
        return helpx(left.left,right.right) && helpx(left.right,right.left);
    }
}
