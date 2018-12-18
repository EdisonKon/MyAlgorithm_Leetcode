package Integers;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-18 16:58
 * @from https://leetcode.com/problems/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */

public class UniquePaths {
    public UniquePaths() {

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n==0){
            return 0;
        }
        int min = m>n?n:m;
        int max = m>n?m:n;
        int[] res = new int[min];
        res[0] = 1;
        for (int i = 0; i < max; i++) {
            for (int j = 1; j < min; j++) {
                res[j] += res[j-1];
            }
        }
        return res[min-1];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths(7,3));
    }
}

