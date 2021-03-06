package DP;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-25 15:20
 * @from  两个字符串修改距离(就是有1->2的操作次数)
 * S:"algorithm"
 * T:"altruistic"
 * 可以2个字符是相等:说明没变化 不加1
 * t[i] 由空白 - > s[j] 字母 +1
 * t[i] 由字母 - > s[j] 空白 +1
 * t[i] 由字母 - > s[j] 字母 +1
 * 3种情况 都是+1,并且需要判断上一步的最小值
 * 也就是 1 + Math.min(
 *                     dp[i-1][j-1],
 *                     dp[i][j-1],
 *                     dp[i-1][j]
 *                     );
 *
 *                     3种值的最小值;
 **/
public class EditDistance {
    public EditDistance() {

    }

    public int editDistance(String s,String t){
        int sl = s.length()+1;
        int tl = t.length()+1;
        int[][] dp = new int[sl][tl];
        for (int i = 0; i < sl; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < tl; j++) {
            dp[0][j] = j;
        }

        printx(dp);

        for (int i = 1; i < sl; i++) {
            for (int j = 1; j < tl; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        printx(dp);

        return dp[sl-1][tl-1];
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
        editDistance("algorithm","altruistic");


    }
}
