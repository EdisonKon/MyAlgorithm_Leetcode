package Entitys;

import BinaryTree.BinaryTreeMaxPathSum;

/**
 * @description: 描述
 * @author: dekai.kong
 * @date: 2019-01-08 11:21
 * @from
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode genTreeNode(int[] ints, int index){
        TreeNode temp = new TreeNode();
        if(ints[index]==0){
            return null;
        }else{
            temp.val = ints[index];
            if(2*index+1<ints.length){
                temp.left = genTreeNode(ints,2*index+1);
                temp.right = genTreeNode(ints,2*index+2);
            }
        }
        return temp;
    }
    public static TreeNode genTreeNode(String s){
        int[] ints = new int[s.length()];
        for (int i =0;i<s.length();i++){
            ints[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return genTreeNode(ints,0);
    }
}

