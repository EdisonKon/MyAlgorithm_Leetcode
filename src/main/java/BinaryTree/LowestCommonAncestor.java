package BinaryTree;

import Entitys.ListNode;
import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2020-07-22 15:06
 * @from 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 滴滴考过,回溯算法
 **/
public class LowestCommonAncestor {
    public LowestCommonAncestor() {

    }

    /**
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 27.59%
     * 的用户
        双list去遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();
        if(root == null||root == p||root == q){
            return root;
        }
        if(p == q){
            return p;
        }

        helper(root,p,listp);
        helper(root,q,listq);
        TreeNode ans = null;
        int i = 0;
        while(i<listp.size()&&i<listq.size() &&listp.get(i) == listq.get(i)){
            ans = listp.get(i);
            i++;
        }
        return ans;
    }
    public void helper(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        if(root.left!=null){
            helper(root.left,p,list);
        }
        if(root.right!=null){
            helper(root.right,p,list);
        }
        if(list.get(list.size()-1).val == p.val){
            return;
        }
        list.remove(list.size()-1);
    }


    /**
     * 超屌代码
     * 分2种情况 :
     * 1:都在同一边,那就是谁高是谁
     * 2:在两边 那肯定是父节点
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 42.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null||root.val == p.val||root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        return left == null?right:right==null?left:root;
    }

    @Test
    public void test() {
        TreeNode tn = TreeNode.genTreeNode(new int[]{3,5,1,6,2,9,8,0,0,7,4},0);
//        lowestCommonAncestor(tn,new TreeNode(5),new TreeNode(4));
        System.out.println(lowestCommonAncestor2(tn,new TreeNode(5),new TreeNode(4)).val);
    }
}
