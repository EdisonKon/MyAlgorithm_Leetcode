package DP;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult middle
 * @create 2019-08-30 16:02
 * @from
 *
 * 小偷背包问题,一个小偷偷东西,包的大小是C
 * 每样东西无限多个/只有一个,并且有他们自己的价值
 * 问最终能最多能拿多少钱
 **/
public class GetMostMoneyWithBag {
    public GetMostMoneyWithBag() {

    }

//    private int[] vals = {10,25,40};
//    private int[] wits = {2,3,5};
    private int[] vals = {25,40};
    private int[] wits = {3,5};
    private int C = 7;

    /**
     * 有三种东西 分别是价值 vals = 10,20,30 重量wits = 2,3,5的
     * 包大小是c = 15 求最后最多能拿多少钱的东西
     * 东西不限个数
     */

    public int getMost(int[] vals,int[] wits,int C){
        int[] dp = new int[C+1];
        for (int k = 0; k < dp.length; k++) {
            for (int j = 0; j < wits.length; j++) {
                if(k>=wits[j]){
                    dp[k] = Math.max(dp[k],dp[k-wits[j]]+vals[j]);
                }
            }
        }
        return dp[C];
    }

    private int[] vs = {10,25,40};
    private int[] ws = {1,3,5};
    private int bC = 7;
    /**
     * 有三种东西 分别是价值 vals = 10,20,30 重量wits = 2,3,5的
     * 包大小是bc = 15 求最后最多能拿多少钱的东西
     * 东西有个数
     */

    public int getMost2(int[] vs,int[] ws,int C){
        int[][] dp = new int[ws.length+1][C+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=ws[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-ws[i-1]]+vs[i-1]);
                }
            }
        }
        return dp[ws.length][C];
    }


    @Test
    public void test() {
        System.out.println(getMost(vals,wits,C));
        System.out.println(getMost2(vs,ws,bC));
    }
}
