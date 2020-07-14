package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 21:36
 * @from 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路,后序遍历,并记录当前节点的左右子树深度差,选出最深的一条
 **/
public class IsBalanced {
    public IsBalanced() {

    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.91%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root){
        if(root!=null){
            //后序遍历
            int l = helper(root.left);
            if(l == -1) return -1;
            int r = helper(root.right);
            if(r == -1) return -1;
            System.out.println(l - r);
            //对左右子树进行深度计算,如果是平衡树,那么就返回当前节点子树支最长的那条
            return Math.abs(l - r)>1?-1:Math.max(l,r)+1;
        }
        return 0;
    }
    public boolean helper(TreeNode root,int dis){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode tn = queue.poll();
            if(tn.left!=null){
                dis++;
                queue.offer(tn.left);
            }
            if(tn.right!=null){
                dis--;
                queue.offer(tn.right);
            }
            if(dis>1||dis<-1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {

    }
}
