package Lists;

import Entitys.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述 Medium  95. Unique Binary Search Trees II
 * @author: dekai.kong
 * @date: 2019-01-11 11:08
 * @from https://leetcode.com/problems/unique-binary-search-trees/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  TODO https://www.youtube.com/watch?v=n5a4maM4eb8
 */

public class UniqueBinarySearchTreesII {
    public UniqueBinarySearchTreesII() {

    }

    /**
     * Runtime: 3 ms, faster than 91.82% of Java online submissions for Unique Binary Search Trees II.
     * 递归法 https://www.youtube.com/watch?v=GZ0qvkTAjmw
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ax = helper(1,n);
        return ax;
    }

    public List<TreeNode> helper(int min,int max){
        List<TreeNode> res = new ArrayList<>();
        if(min>max) return res;
        for (int i = min; i <=max ; i++) {
            List<TreeNode> left = helper(min,i-1);
            List<TreeNode> righ = helper(i+1,max);
            if(left.size() == 0 && righ.size() == 0){
                TreeNode root = new TreeNode(i);
                res.add(root);
            }
            else if(left.size() == 0){
                for (TreeNode r: righ) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    res.add(root);
                }
            }
            else if(righ.size() == 0){
                for (TreeNode l: left) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    res.add(root);
                }
            }
            else{
                for (TreeNode l: left) {
                    for (TreeNode r: righ) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(generateTrees(3));
    }
}

