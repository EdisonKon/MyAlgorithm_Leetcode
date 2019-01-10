package Integers;

import org.junit.Test;

/**
 * @description: 描述 Medium  96. Unique Binary Search Trees
 * @author: dekai.kong
 * @date: 2019-01-10 11:08
 * @from https://leetcode.com/problems/unique-binary-search-trees/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *    卡塔兰数
 *    http://www.cnblogs.com/grandyang/p/4299608.html
 *    这道题实际上是 Catalan Number卡塔兰数的一个例子，如果对卡塔兰数不熟悉的童鞋可能真不太好做。话说其实我也是今天才知道的好嘛-.-|||，为啥我以前都不知道捏？！为啥卡塔兰数不像斐波那契数那样人尽皆知呢，是我太孤陋寡闻么？！不过今天知道也不晚，不断的学习新的东西，这才是刷题的意义所在嘛! 好了，废话不多说了，赶紧回到题目上来吧。我们先来看当 n = 1的情况，只能形成唯一的一棵二叉搜索树，n分别为1,2,3的情况如下所示：
 *
 *
 *
 * 复制代码
 *                     1                        n = 1
 *
 *                 2        1                   n = 2
 *                /          \
 *               1            2
 *
 *    1         3     3      2      1           n = 3
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 复制代码
 *
 *
 * 就跟斐波那契数列一样，我们把n = 0 时赋为1，因为空树也算一种二叉搜索树，
 * 那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，所以1乘1还是1。
 * 那么n = 2时，由于1和2都可以为跟，分别算出来，再把它们加起来即可。n = 2的情况可由下面式子算出：
 *
 * dp[2] =  dp[0] * dp[1]　　　(1为根的情况)
 *
 * 　　　　+ dp[1] * dp[0]　　  (2为根的情况)
 *
 * 同理可写出 n = 3 的计算方法：
 *
 * dp[3] =  dp[0] * dp[2]　　　(1为根的情况)
 *
 * 　　　　+ dp[1] * dp[1]　　  (2为根的情况)
 *
 *  　　　  + dp[2] * dp[0]　　  (3为根的情况)
 *
 *
 * 我们根据以上的分析，可以写出代码如下：
 */

public class UniqueBinarySearchTrees {
    public UniqueBinarySearchTrees() {

    }

    /**
     * Runtime: 0 ms , faster than 100% of Java online submissions for Unique Binary Search Trees.
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {//从2开始遍历n
            for (int j = 0; j < i; ++j) {//遍历当前的可当根节点的数
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
    }
}

