package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 14:28
 * @from 617. Merge Two Binary Trees
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MergeTwoBinaryTrees {
    public MergeTwoBinaryTrees() {

    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.2 MB
     * , 在所有 Java 提交中击败了
     * 64.71%
     * 的用户
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2 == null){
            return null;
        }else if(t1 == null){
            t1 = t2;
        }else if(t2 != null){
            t1.val = t1.val+t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
        }
        return t1;
    }

    @Test
    public void test() {

    }
}
