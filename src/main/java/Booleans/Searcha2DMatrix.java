package Booleans;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-20 17:03
 * @from https://leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */

public class Searcha2DMatrix {
    public Searcha2DMatrix() {

    }

    /**
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }else{
            int mlen = matrix.length;
            int nlen = matrix[0].length;
            for (int i = 0; i < mlen; i++) {
                if(matrix[i][0]> target){
                    return false;
                }else if(matrix[i][0] == target){
                    return true;
                }else {
                    if(matrix[i][nlen-1] < target){
                        continue;
                    }else if(matrix[i][nlen-1] == target){
                        return true;
                    }else{
                        for (int j = 1; j < matrix[i].length-1; j++) {
                            if(matrix[i][j]>target){break;}
                            if(matrix[i][j] == target){
                                return true;
                            }
                        }
                        break;
                    }
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}},13));
    }
}

