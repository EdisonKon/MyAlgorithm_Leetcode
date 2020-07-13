package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 15:29
 * @from 872. Leaf-Similar Trees
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *  
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路 : 遍历出2棵树所有的叶子节点,第一棵树的叶子节点与第二个进行对比,相同则true 不同则false  DFS
 **/
public class LeafSimilar {
    public LeafSimilar() {

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
     * 33.33%
     * 的用户
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        helper(root1,l1);
        helper(root2,l2);
        System.out.println(l1);
        System.out.println(l2);
        if(l1.size()!=l2.size()){
            return false;
        }
        return l1.equals(l2);

    }

    private void helper(TreeNode root, List<Integer> l) {
        if(root!=null){
            if(root.left==null && root.right == null){
                l.add(root.val);
            }
            helper(root.left,l);
            helper(root.right,l);
        }
    }

    @Test
    public void test() {

        leafSimilar(new TreeNode(1),new TreeNode(2));
    }
}
