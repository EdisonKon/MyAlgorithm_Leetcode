package Void;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-20 16:06
 * @from https://leetcode.com/problems/set-matrix-zeroes/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class SetMatrixZeroes {
    public SetMatrixZeroes() {

    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if(matrix!=null&&matrix.length!=0&&matrix[0].length!=0){
            int m = matrix.length;
            int n = matrix[0].length;
            int[] ns = new int[matrix[0].length];
            for (int i = 0; i < m; i++) {
                boolean isZ = false;
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0){
                        ns[j] = 1;
                        isZ = true;
                    }
                }
                if(isZ){
                    Arrays.fill(matrix[i],0);
                }
            }
            for (int i = 0; i < n; i++) {
                if(ns[i] == 1){
                    for (int j = 0; j < m; j++) {
                        matrix[j][i] =0;
                    }
                }
            }
        }
    }
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        if(matrix!=null&&matrix.length!=0&&matrix[0].length!=0){
            int m = matrix.length;
            int n = matrix[0].length;
            int[] ns = new int[matrix[0].length];
            for (int i = 0; i < m; i++) {
                boolean isZ = false;
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0){
                        ns[j] = 1;
                        isZ = true;
                        if(i>0){
                            for (int k = i-1; k >= 0 ; k--) {
                                if(matrix[k][j] != 0){
                                    matrix[k][j] = 0;
                                }
                            }
                        }
                    }else{
                        if(ns[j] == 1){
                            matrix[i][j] = 0;
                        }
                    }
                }
                if(isZ){
                    Arrays.fill(matrix[i],0);
                }
            }
        }
    }

    @Test
    public void test() {
//        setZeroes(new int[][]{
//                {1,1,1},
//                {1,0,1},
//                {1,1,1}
//                });
        setZeroes(new int[][]{
                {1,1,2,1},
                {0,1,2,0},
                {3,0,5,2},
                {1,3,1,5}
        });
    }
}

