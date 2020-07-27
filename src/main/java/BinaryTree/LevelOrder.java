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
 * @create 2020-07-27 12:27
 * @from 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LevelOrder {
    public LevelOrder() {

    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 93.37%
     * 的用户
     * 内存消耗：
     * 40 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            /** 记录层级 最关键 i=当前que的大小 并且减法 */
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tn = queue.poll();
                list.add(tn.val);
                if(tn.left!=null){
                    queue.offer(tn.left);
                }
                if(tn.right!=null){
                    queue.offer(tn.right);
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }





    @Test
    public void test() {
//        List<List<Integer>> l = levelOrder(TreeNode.genTreeNode(new int[]{3,9,20,0,0,15,7},0));
        List<List<Integer>> l = levelOrder(TreeNode.genTreeNode(new int[]{1,2,3,4,5},0));
        System.out.println(l);
    }
}
