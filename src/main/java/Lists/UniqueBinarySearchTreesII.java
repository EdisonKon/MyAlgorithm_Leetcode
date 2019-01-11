package Lists;

import Entitys.TreeNode;
import org.junit.Test;

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
 *
 */

public class UniqueBinarySearchTreesII {
    public UniqueBinarySearchTreesII() {

    }

    /**
     * Runtime: 0 ms , faster than 100% of Java online submissions for Unique Binary Search Trees.
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {

    }

    @Test
    public void test() {
    }
}

