package Entitys;

import BinaryTree.BinaryTreeMaxPathSum;
import com.sun.deploy.util.StringUtils;

import java.util.*;

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
        if(index >= ints.length){
            return null;
        }
        if(ints[index]==0||ints[index] == -1){
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
    public static TreeNode genTreeNode(String data){
//        int[] ints = new int[data.length()];
//        for (int i =0;i<data.length();i++){
//            String x = String.valueOf(data.charAt(i));
//            ints[i] = Integer.parseInt("-".equals(x)? "-1" :x);
//        }
        String[] stris = data.split(",");
        int[] ints =  Arrays.stream(stris).mapToInt(Integer::parseInt).toArray();
        return genTreeNode(ints,0);
    }

    /**
     * tree转string 层序遍历
     * @return
     */
    public static String tree2String(TreeNode root){
        if(root == null){
            return "-1";
        }
        List<Integer> arrs = new ArrayList<>();
        int place = -1;
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode pop = (TreeNode)queue.poll();
            int v = pop.val;
            arrs.add(v);
            if(pop.left!=null && pop.right!=null){
                queue.add(pop.left);
                queue.add(pop.right);
            }else if (pop.left!=null){
                queue.add(pop.left);
                if(pop.left.left!=null || pop.left.right!=null){
                    queue.add(new TreeNode(place));
                }
            }else if(pop.right!=null){
                queue.add(new TreeNode(place));
                queue.add(pop.right);
            }else if(pop.val!=-1 && !queue.isEmpty()){
                queue.add(new TreeNode(place));
                queue.add(new TreeNode(place));
            }
        }
        String rst = "";
        for (int i = 0; i < arrs.size(); i++) {
            rst+=(arrs.get(i)+",");
        }
        return rst;
    }


    public class Codec {

        // Encodes a tree to a single string.
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
    }
}

