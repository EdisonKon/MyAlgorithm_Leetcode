package Integers;

import org.junit.Test;

import java.util.Arrays;

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

    public int maximalRectangle2(char[][] matrix) {
        int res = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] record = new int[m][n];//1是左右,2是上下,3是全都有
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                helper(res,i,j,record,matrix,0);
            }
        }

        return res;
    }
    public int helper(int res,int i,int j,int[][] record ,char[][] matrix,int from){
        int infrom = from;
        if(i<=matrix.length-1&&j<=matrix[0].length-1){
            if (matrix[i][j] !=0){
                res = Math.max(res,(i+1)*(j+1));
                if(record[i][j]==0 || from == 0){
                    if (matrix[i][j+1]!=0 && matrix[i+1][j] !=0){//可以往下右走
                        record[i][j] =3;
                        helper(res,i+1,j,record,matrix,3);
                        helper(res,i,j+1,record,matrix,3);
                        helper(res,i+1,j+1,record,matrix,3);
                    }else if(matrix[i][j+1]==0){//可以往下走
                        record[i][j] =2;
                        helper(res,i+1,j,record,matrix,2);
                    }else{//可以往左走
                        record[i][j] =1;
                        helper(res,i+1,j,record,matrix,1);
                    }
                }
            }
        }

        return infrom;
    }


    public int maximalRectangle3(char[][] matrix) {
        int res = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] record = new int[n][2];//n列 长和宽
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mych(res,i,j,record,matrix,record[j][1]);
            }

        }

        return res;
    }
    public void mych(int max, int i,int j,int[][] record ,char[][] matrix,int width){
        if(i<=matrix.length-1&&j<=matrix[0].length-1){
            if(matrix[i][j] == '0'){
                record[j][0]=0;
                record[j][1]=0;
                return;
            }else{
                if(i>0){
                    record[j][0]+=1;

                    if(record[j][1] == 0){
                        record[j][1] = 1;
                    }else{
//                        int curj = 1;
//                        int cj = j-1;
//                        while(curj <= record[j][1] && j > 0 && record[cj][1]!=0){
//                            curj++;
//                        }
                    }

                    if (j>0){
                        int val = record[j][1] + record[j-1][1];
                        if(val > record[j][1]){
                            record[j][0] += record[j-1][1];
                        }
                        record[j][1] += record[j-1][1];
                    }
                    max = Math.max(max,record[j][0]*record[j][1]);
                }else{
                    int curw = width+1;
                    record[j][0]=1;
                    record[j][1]=curw;
                    mych(max,i,j+1,record,matrix,curw+1);
                    max = Math.max(max,record[j][0]*record[j][1]);
                }

            }
        }

    }


    /**
     * Runtime: 8 ms, faster than 87.97% of Java online submissions for Maximal Rectangle.
     * @param matrix
     * @return
     * 借鉴DP from https://www.youtube.com/watch?v=5CEBM_174e0
     * l[] 从左到右，出现连续'1'的char的第一个坐标
     * r[] 从右到左，出现连续'1'的char的最后一个坐标
     * h[] 从上到下的高度
     */
    public int maximalRectangle(char[][] matrix){
        int res = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] h = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];

        Arrays.fill(r,n);
        for (int i = 0; i < m; i++) {
            int curL = 0, curR = n;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') h[j]++;
                else h[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    l[j] = Math.max(curL,l[j]);
                }else{
                    l[j] =0;
                    curL = j+1;
                }
            }
            for (int j = n-1; j >= 0; j--) {
                if(matrix[i][j] == '1'){
                    r[j] = Math.min(curR,r[j]);
                }else{
                    r[j] = n;
                    curR = j;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res,(r[j]-l[j])*h[j]);
            }
        }


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

