package Integers;

import org.junit.Test;

/**
 * @description: 描述 Hard
 * @author: dekai.kong
 * @date: 2018-12-27 17:10
 * @from https://leetcode.com/problems/maximal-rectangle/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ['1','0','1','0','0'],
 *   ['1','0','1','1','1'],
 *   ['1','1','1','1','1'],
 *   ['1','0','0','1','0']
 * ]
 * Output: 6
 */

public class MaximalRectangle {
    public MaximalRectangle() {

    }

    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] record = new int[m][n];//1是左右,2是上下,3是全都有

        return res;
    }

    @Test
    public void test() {
        maximalRectangle(new char[][]{
                        {'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                        });
    }
}

