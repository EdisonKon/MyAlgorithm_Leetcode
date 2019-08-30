package MyArrays;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult middle
 * @create 2019-08-30 10:45
 * @from 华为笔试算法(最多年终奖)
 * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
 * 游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
 * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，
 * 请设计一个算法使小东拿到价值最高的礼物。
 * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，
 * 保证每个礼物价值大于100小于1000。
 *
 **/
public class FinalMoneyByDP {
    private int[][] board = {
            {  0,306,641,372,131,448},
            {477,409,223,172,178,264},
            {327,586,363,553,207,676},
            {292,645,248,316,655,407},
            {711,295,127,192,309,358},
            {495,208,547,175,246,714}
    };
    private int[][] board2 = {
            {0,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,2,1},
            {1,1,1,1,1,1}
    };

    public FinalMoneyByDP() {

    }

    public int getMost(int[][] board){
        int r = board.length;
        int c = board[0].length;

        int[][] dp = board;
        for (int i = 1; i < r; i++) {
            dp[i][0] += dp[i-1][0];
        }
        for (int j = 1; j < c; j++) {
            dp[0][j] += dp[0][j-1];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] += Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[r-1][c-1];
    }


    @Test
    public void test() {
        System.out.println(getMost(board2));
    }
}
