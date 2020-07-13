package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 14:56
 * @from 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IincreasingBST {
    public IincreasingBST() {

    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        helper(root,vals);
        root.val = vals.get(0);
        root.left = null;
        TreeNode tn = root;
        for (int i = 1; i < vals.size(); i++) {
            root.left = null;
            root.right = new TreeNode(vals.get(i));
            root = root.right;
        }
        return tn;
    }
    public void helper(TreeNode root,List<Integer> vals){
        if(root==null){
            return ;
        }
        helper(root.left,vals);
        vals.add(root.val);
        helper(root.right,vals);
    }

    @Test
    public void test() {

    }

}
