package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-14 12:38
 * @from 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路,前序遍历,然后挨个比对
 **/
public class IsSubtree {
    public IsSubtree() {

    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    /**
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 76.64%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 60.00%
     * 的用户
     * 炫耀一下:
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return helper(s,t)||isSubtree2(s.left,t)||isSubtree2(s.right,t);
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return (helper(s.left,t.left)&&helper(s.right,t.right));
    }

    @Test
    public void test() {
        System.out.println(isSubtree2(TreeNode.genTreeNode("345120010"),TreeNode.genTreeNode("412")));
//        System.out.println(isSubtree2(TreeNode.genTreeNode("110"),TreeNode.genTreeNode("1")));
    }
}
