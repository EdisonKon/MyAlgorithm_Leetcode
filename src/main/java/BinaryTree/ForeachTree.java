package BinaryTree;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 描述 easy
 * @author: dekai.kong
 * @date: 2019-05-09 17:46
 * @from
 */

public class ForeachTree {
    public ForeachTree() {

    }
    //递归前序
    public void preForEach(TreeNode root){
        while(root==null){
            return;
        }
        System.out.println(root.val);
        preForEach(root.left);
        preForEach(root.right);
    }
    //递归中序
    public void midForEach(TreeNode root){
        while(root==null){
            return;
        }
        midForEach(root.left);
        System.out.println(root.val);
        midForEach(root.right);
    }
    //递归后序
    public void backForEach(TreeNode root){
        while(root==null){
            return;
        }
        backForEach(root.left);
        backForEach(root.right);
        System.out.println(root.val);
    }

    //用栈实现前序遍历
    public void preForEachByStack(TreeNode proot){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = proot;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
    }
    //用栈实现中序遍历
    public void midForEachByStack(TreeNode mroot){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = mroot;
        while(root!= null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
    //用栈实现后序遍历
    public void backForEachByStack(TreeNode broot){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = broot;
        TreeNode prior = null;
        while(root!=null || stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if(root.right == null || root.right == prior){
                    System.out.println(root.val);
                    prior = root;
                    root = null;
                }else{
                    stack.push(root);
                    root = root.right;
                    stack.push(root);
                    root = root.left;
                }
            }
        }
    }
    public void postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        /* 用来记录最新出栈的节点，
         * 如果当前节点的右儿子与flag相同，说明当前节点右子树已完成遍历
         */
        TreeNode flag = null;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right == null || cur.right == flag) {
                System.out.println(cur.val);
                flag = cur;
            }else {
                stack.push(cur);
                cur = cur.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
    }
    /**
     * 层序遍历 (广度优先)
     */
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    @Test

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;
        preForEachByStack(root);
        midForEachByStack(root);
    }


}

