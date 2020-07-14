package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-14 11:16
 * @from 563. 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *  
 *
 * 提示：
 *
 * 任何子树的结点的和不会超过 32 位整数的范围。
 * 坡度的值不会超过 32 位整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路:后序遍历,并且把左子树和右子树的坡度相加
 **/
public class FindTilt {
    public FindTilt() {

    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 33.33%
     * 的用户
     */
    int rst = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return rst;
    }


    public int helper(TreeNode root){
        if (root != null) {
            int left = helper(root.left);
            int right= helper(root.right);
            rst += Math.abs(left-right);
            return root.val+left+right;
        }
        return 0;
    }

    @Test
    public void test() {
        TreeNode tn = TreeNode.genTreeNode(new int[]{1,2,0,3,4},0);
        System.out.println(findTilt(tn));
    }
}
