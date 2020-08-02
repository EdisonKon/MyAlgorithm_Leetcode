package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-08-02 12:36
 * @from
 **/
public class CoinChange {
    public CoinChange() {

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            dp[amount] = -1;
        }
        return dp[amount];
    }



    @Test
    public void test() {
        coinChange(new int[]{2},3);
//        coinChange(new int[]{1,2,5},11);
//        coinChange(new int[]{2,5,10,1},27);
//        coinChange(new int[]{186,419,83,408},6249);
    }
}
