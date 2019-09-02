package zOther;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2019-09-01 13:02
 * @from: 小灰算法
 * 5座金矿10个人 求最多能获取多少金子
 **/

public class TestGetMostGold {
    public TestGetMostGold() {
    }

    private int[] gold = {200,300,350,400,500};
    private int[] peop = {3,4,3,5,5};
    private int c = 10;

    @Test
    public void getMost(){
        int[][] dp = new int[peop.length+1][c+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=peop[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],gold[i-1]+dp[i-1][j-peop[i-1]]);
                }
            }
        }
        System.out.println(dp[peop.length][c]);
    }

}
