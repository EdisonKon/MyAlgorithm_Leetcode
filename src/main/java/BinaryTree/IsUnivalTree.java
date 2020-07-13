package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 15:12
 * @from 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IsUnivalTree {
    public IsUnivalTree() {

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
     * 37.3 MB
     * , 在所有 Java 提交中击败了
     * 25.00%
     * 的用户
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        int val = root.val;
        return helper(root,val);
    }

    public boolean helper(TreeNode root,int val){
        if(root==null){
            return true;
        }
        if(val == root.val){
            if(helper(root.left,val)){
                return helper(root.right,val);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Test
    public void test() {

    }
}
