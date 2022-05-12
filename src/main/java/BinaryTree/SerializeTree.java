package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dekai.kong
 * @difficult mid
 * @create 2022-05-11 15:41
 * @from https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 **/

/**
 * 注意 二叉搜索树: 左小于中小于右, 所以使用前序遍历一次就可以完成
 * 其他二叉树 要想还原的话 需要至少2种遍历才能还原
 */
public class SerializeTree {
    public String serialize(TreeNode root) {
        if(root==null){return "#";}
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        StringBuilder ans=new StringBuilder();
        while(q.size()>0){
            TreeNode t=q.poll();
            ans.append("#");
            if(t!=null){
                ans.append(t.val);
                q.add(t.left);
                q.add(t.right);
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")){return null;}
        String s[]=data.split("#",-1);
        TreeNode ans=new TreeNode(Integer.parseInt(s[1]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(ans);
        for(int i=3;i<s.length;i+=2){
            TreeNode t=q.poll();
            if(s[i-1].length()>0){
                t.left=new TreeNode(Integer.parseInt(s[i-1]));
                q.add(t.left);
            }
            if(s[i].length()>0){
                t.right=new TreeNode(Integer.parseInt(s[i]));
                q.add(t.right);
            }
        }
        return ans;
    }


    @Test
    public void test() {

    }
}
