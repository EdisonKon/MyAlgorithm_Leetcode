package DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult middle
 * @create 2019-08-30 13:53
 * @from 给出一组硬币,找到最少的硬币数凑出钱数
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * https://blog.csdn.net/wjheha/article/details/77924642
 **/
public class FindMinUse4Money {
    public FindMinUse4Money() {

    }

    public int[] coins = {3,5};
    public int gol = 7;

    public int findMin(int[] coins,int gol){
        int[] dp = new int[gol+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i =0;i<dp.length;i++){
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i - coins[j]]+1 ,dp[i]);
                }
            }
        }
        return dp[gol]== Integer.MAX_VALUE-1?-1:dp[gol];
    }

    @Test
    public void test() {
        try {
            int x = findMin(coins, gol);
            System.out.println(x);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
