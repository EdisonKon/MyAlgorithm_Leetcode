package DP;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-25 15:47
 * @from
 **/
public class LongestConSubString {
    public LongestConSubString() {

    }

    public int longestStringLength(String m,String n){
        int ml = m.length()+1;
        int nl = n.length()+1;
        int[][] dp = new int[ml][nl];
        int max = 0;
        printx(dp);
        for (int i = 1; i < ml; i++) {
            for (int j = 1; j < nl; j++) {
                if(m.charAt(i-1) == n.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        printx(dp);
        return max;
    }

    public void printx(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------");
    }

    @Test
    public void test() {
        longestStringLength("abcd","cbca");
    }
}
