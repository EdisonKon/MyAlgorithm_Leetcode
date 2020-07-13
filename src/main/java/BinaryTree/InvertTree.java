package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 13:12
 * @from
 * 剑指 Offer 27. 二叉树的镜像
 * 226. 翻转二叉树
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路,先根据给出的层序遍历构建出二叉树,然后中序遍历读出顺序list 反转之后再给tree再由层序遍历读出
 *
 * 思路2 根据树的特点,第一层2^0次方 第二层 2^1 第三层 2^2
 *
 * 思路3 层序遍历 放入队列后,再进行交换
 **/
public class InvertTree {
    public InvertTree() {

    }
    //[4,2,7,1,3,6,9]

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tn = queue.poll();
            System.out.println(tn.val);
            if(tn.right!=null){
                queue.offer(tn.right);
            }
            if(tn.left!=null){
                queue.offer(tn.left);
            }
            TreeNode tmp = tn.left;
            tn.left = tn.right;
            tn.right = tmp;
        }
        return root;
    }

    /**
     * 226 翻转二叉树
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tn = queue.poll();
            if(tn.left!=null){
                queue.offer(tn.left);
            }
            if(tn.right!=null){
                queue.offer(tn.right);
            }
            TreeNode tmp = tn.left;
            tn.left = tn.right;
            tn.right = tmp;
        }
        return root;
    }

    @Test
    public void test() {
        mirrorTree(TreeNode.genTreeNode(new int[]{4,2,7,1,3,6,9},0));
    }
}
