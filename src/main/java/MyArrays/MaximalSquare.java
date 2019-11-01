package MyArrays;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import zUtils.ForMatrixArrays;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2019-11-01 15:12
 * @from https://leetcode.com/problems/maximal-square/submissions/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 **/
public class MaximalSquare {
    public MaximalSquare() {

    }

    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int m = matrix.length;
        if(m==0){
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[m][n];

        //初始化dp
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    dp[i][j] = matrix[i][j]-'0';
                }else{
                    dp[i][j] = 0;
                }
                if(maxLen == 0 && matrix[i][j]=='1' ){
                    maxLen = 1;
                }
            }
        }
        ForMatrixArrays.forMatrixArrays(dp);
        //开始dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] - '0' == 0){
                    dp[i][j] = 0;
                }else{
                    int minLen = 0;
                    minLen = Math.min(dp[i-1][j],dp[i][j-1]);
                    minLen = Math.min(minLen,dp[i-1][j-1]);
                    dp[i][j] = matrix[i][j] - '0' + minLen;
                    if(dp[i][j]>maxLen){
                        maxLen = dp[i][j];
                    }
                }
            }
        }

        return maxLen*maxLen;
    }

    @Test
    public void test() {
        char[][] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] a2 = {{'1','0','1','1','0','1'},{'1','1','1','1','1','1'},{'0','1','1','0','1','1'},{'1','1','1','0','1','0'},{'0','1','1','1','1','1'},{'1','1','0','1','1','1'}};
        System.out.println(maximalSquare(a2));
    }
}
