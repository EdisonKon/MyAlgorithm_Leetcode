package Integers;

import org.junit.Test;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-20 11:00
 * @from https://leetcode.com/problems/edit-distance/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * 这道题让求从一个字符串转变到另一个字符串需要的变换步骤，共有三种变换方式，插入一个字符，删除一个字符，和替换一个字符。
 * 根据以往的经验，对于字符串相关的题目十有八九都是用动态规划Dynamic Programming来解，这道题也不例外。
 * 这道题我们需要维护一个二维的数组dp，其中dp[i][j]表示从word1的前i个字符转换到word2的前j个字符所需要的步骤。
 * 那我们可以先给这个二维数组dp的第一行第一列赋值，这个很简单，因为第一行和第一列对应的总有一个字符串是空串，于是转换步骤完全是另一个字符串的长度。
 * 跟以往的DP题目类似，难点还是在于找出递推式，我们可以举个例子来看，比如word1是“bbc"，word2是”abcd“，那么我们可以得到dp数组如下：
 *
 *
 *
 *   Ø a b c d
 * Ø 0 1 2 3 4
 * b 1 1 1 2 3
 * b 2 2 1 2 3
 * c 3 3 2 1 2
 *
 *
 * 我们通过观察可以发现，当word1[i] == word2[j]时，dp[i][j] = dp[i - 1][j - 1]，其他情况时，dp[i][j]是其左，左上，上的三个值中的最小值加1，那么可以得到递推式为：
 *
 * dp[i][j] =      /    dp[i - 1][j - 1]                                                        if word1[i - 1] == word2[j - 1]
 *                 \    min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1              else
 */

public class EditDistance {
    public EditDistance() {

    }

    /**
     * Runtime: 5 ms, faster than 94.84% of Java online submissions for Edit Distance.
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] res = new int[len1+1][len2+1];
        for (int i = 0; i < len1 + 1; i++) {
            res[i][0] = i;
            for (int j = 0; j < len2 + 1; j++) {
                if(i == 0){
                    res[i][j] = j;
                }else if(j>0){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        res[i][j] = res[i-1][j-1];
                    }else{
                        int min = Math.min(res[i][j-1],res[i-1][j]);
                        res[i][j] = Math.min(min,res[i-1][j-1])+1;
                    }
                }
            }
        }
        return res[len1][len2];
    }

    @Test
    public void test() {
//        System.out.println(minDistance("horse", "ros"));
//        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("dinitrophenylhydrazine","dimethylhydrazine"));
    }
}

