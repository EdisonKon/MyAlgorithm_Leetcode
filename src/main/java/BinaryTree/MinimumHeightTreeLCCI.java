package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-13 12:17
 * @from 面试题 04.02. Minimum Height Tree LCCI
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * Given a sorted (increasing order) array with unique integer elements, write an algo­rithm to create a binary search tree with minimal height.
 *
 * Example:
 *
 * Given sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5]，which represents the following tree:
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 直接给出排序好的,就直接中序遍历并赋值,直接构建就好
 **/
public class MinimumHeightTreeLCCI {
    public MinimumHeightTreeLCCI() {

    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 47.59%
     * 的用户
     * 内存消耗：
     * 40.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = helper(nums);
        return treeNode;
    }

    public TreeNode helper(int[] nums){
        if(nums.length==0) return null;
        TreeNode tree = new TreeNode(nums[nums.length/2]);
        tree.left = helper(Arrays.copyOfRange(nums,0,nums.length/2));
        tree.right = helper(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return tree;
    }


    @Test
    public void test() {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
