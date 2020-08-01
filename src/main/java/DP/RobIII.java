package DP;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2020-08-01 20:45
 * @from
 **/
public class RobIII {
    public RobIII() {

    }

    /**
     * 层序遍历 此解法不对,因为 不能选跨层的,所以要使用后续遍历
     */
    List<List<Integer>> level = new ArrayList();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode tn = q.poll();
                list.add(tn.val);
                if (tn.left != null) {
                    q.offer(tn.left);
                }
                if (tn.right != null) {
                    q.offer(tn.right);
                }
            }
            level.add(new ArrayList(list));
        }
        int[] dp = new int[level.size()];
        dp[0] = level.get(0).get(0);
        if(level.size() == 1){
            return dp[0];
        }
        int lv1 = 0;
        for (int i = 0; i < level.get(1).size(); i++) {
            lv1 += level.get(1).get(i);
        }
        dp[1] = Math.max(dp[0], lv1);
        for (int i = 2; i < level.size(); i++) {
            int lvi = 0;
            for (int j = 0; j < level.get(i).size(); j++) {
                lvi += level.get(i).get(j);
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + lvi);
        }
        return dp[level.size() - 1];
    }


    /**
     * 0ms 100%
     * @param root
     * @return
     */
    public int rob2(TreeNode root){
        if(root == null){
            return 0;
        }
        int[] ans = helper(root);
        return  Math.max(ans[0],ans[1]);
    }
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int[] dp = new int[2];
        //不选根 选子节点的子节点里最大的
        dp[0] = Math.max(left[0],left[1])+ Math.max(right[0],right[1]);
        //选根 肯定选子节点的子节点
        dp[1] = root.val + left[0]+right[0];
        return dp;
    }

    @Test
    public void test() {
        TreeNode tn = TreeNode.genTreeNode(new int[]{1},0);
        rob2(tn);
    }
}
