package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author dekai.kong
 * @difficult Hard
 * @create 2020-07-19 19:58
 * @from 牛客网
 *      给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 **/
public class KMinNode {
    public KMinNode() {

    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){
            return pRoot;
        }
        List<Integer> mins = new ArrayList<>();
        Map<Integer,TreeNode> map = new HashMap<>();
        Queue queue = new LinkedList();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            TreeNode cur = (TreeNode)queue.poll();
            mins.add(cur.val);
            map.put(cur.val,cur);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
        if(k == 0|| k>mins.size()){
            return null;
        }
        Collections.sort(mins);
        return map.get(mins.get(k-1));
    }

    @Test
    public void test() {

    }
}
