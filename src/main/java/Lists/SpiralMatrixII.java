package Lists;

import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-14 17:20
 * @from    https://leetcode.com/problems/spiral-matrix-ii/
 * 可参考http://www.cnblogs.com/grandyang/p/4362813.html
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

public class SpiralMatrixII {
    public SpiralMatrixII() {

    }
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
     * @param n
     * @return
     */
    public int[][] generateMatrix2(int n){
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, val = 1;
        while (true) {//上右下左循环
            for (int j = left; j <= right; ++j) res[up][j] = val++;
            if (++up > down) break;
            for (int i = up; i <= down; ++i) res[i][right] = val++;
            if (--right < left) break;
            for (int j = right; j >= left; --j) res[down][j] = val++;
            if (--down < up) break;
            for (int i = down; i >= up; --i) res[i][left] = val++;
            if (++left > right) break;
        }
        return res;
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int val = 1, p = n;
        for (int i = 0; i < n / 2; ++i, p -= 2) {
            for (int col = i; col < i + p; ++col)
                res[i][col] = val++;
            for (int row = i + 1; row < i + p; ++row)
                res[row][i + p - 1] = val++;
            for (int col = i + p - 2; col >= i; --col)
                res[i + p - 1][col] = val++;
            for (int row = i + p - 2; row > i; --row)
                res[row][i] = val++;
        }
        if (n % 2 != 0) res[n / 2][n / 2] = val;
        return res;
    }

    @Test
    public void test() {
        generateMatrix(3);
    }
}

