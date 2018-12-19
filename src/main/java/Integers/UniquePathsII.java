package Integers;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-18 16:58
 * @from https://leetcode.com/problems/unique-paths-ii/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */

public class UniquePathsII {
    public UniquePathsII() {

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
     * @param o
     * @return
     * 关键点
     * 按行遍历
     * 在于这个点是不是不能通过,如果不能通过,那就让这个点为0,后续经过这个点的也就为0
     * 其次第一行的j 如果这个点可以通过的情况下 这个o[i][0]的点的值都是1,如果通不过 那不用管第一个j 肯定都是0
     */
    public int uniquePathsWithObstacles(int[][] o) {
        if(o==null || o.length == 0 || o[0].length == 0||o[0][0] == 1||o[o.length-1][o[0].length-1] == 1){
            return 0;
        }
//        int min = o.length>o[0].length?o[0].length:o.length;
//        int max = o.length>o[0].length?o.length:o[0].length;
        int row = o.length;
        int col = o[0].length;
        int[] res = new int[col];
        res[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(o[i][j] == 1){
                    res[j] = 0;
                }else if(j>0){
                        res[j] += res[j-1];
                    }
                }
        }
        return res[col-1];
    }

    @Test
    public void test() {
//        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
//        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));
    }
}

