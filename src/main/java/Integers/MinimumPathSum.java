package Integers;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-19 14:09
 * @from https://leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * TODO 可多刷,动规经典(DP)
 */

public class MinimumPathSum {
    public MinimumPathSum() {

    }

    /**
     * Runtime: 6 ms, faster than 51.96% of Java online submissions for Minimum Path Sum.
     * @param grid
     * @return
     * 自己的思想,在当前i,j的位置取左一个和上一个的最小值与当前值求和,然后最后的值就是最小值
     * 即:
     * 1 4 5
     * 2 7 6
     * 6 8 7
     * 最后一个 7 就是路径最小值
     * DP -- >time: O(m*n) mem:O(m*n)
     */
    public int minPathSum2(int[][] grid) {
        if(grid == null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int len = grid.length;
        int inlen = grid[0].length;
        int[][] res = new int[len][inlen];
        res[0][0] = grid[0][0];
        for (int i = 0; i < len; i++) {
            if(i>0){
                res[i][0] = res[i-1][0] + grid[i][0];
            }
            for (int j = 1; j < inlen; j++) {
                if(i ==0){
                    res[i][j] = res[i][j-1] + grid[i][j];
                }else{
                    res[i][j] = Math.min((res[i][j-1] + grid[i][j]),res[i-1][j] + grid[i][j]);
                }
            }
        }
        return res[len-1][inlen-1];
    }

    /**
     * Runtime: 4 ms, faster than 98.24% of Java online submissions for Minimum Path Sum.
     * @param grid
     * @return
     * 还是上边的方法,不需要额外的空间,即使用原数组
     * DP -- >time: O(m*n) mem:0
     * 不另开空间,速度快很多
     */
    public int minPathSum(int[][] grid) {
        if(grid == null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int len = grid.length;
        int inlen = grid[0].length;
        for (int i = 0; i < len; i++) {
            if(i>0){
                grid[i][0] = grid[i-1][0] + grid[i][0];
            }
            for (int j = 1; j < inlen; j++) {
                if(i ==0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else{
                    grid[i][j] = Math.min((grid[i][j-1] + grid[i][j]),grid[i-1][j] + grid[i][j]);
                }
            }
        }
        return grid[len-1][inlen-1];
    }
    @Test
    public void test() {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(minPathSum2(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}

