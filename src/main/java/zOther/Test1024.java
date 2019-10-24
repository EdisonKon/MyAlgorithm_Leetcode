package zOther;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2019-10-24 19:42
 * @from:校友群
 * 从100到200共101个数字中按照顺序取10个数,每个数字可以重复取,使十个数的总和为1024,求共多少种取法
 * 例如 100 100 100 100 100 100 104 106 106 108 可为一种
 * 100 101 与101 100 是2种选择
 **/

public class Test1024 {
    static int[] cons = new int[101];
    static int c = 1024;

    public static int chargeTypes(int[] vals, int n){
        int m = vals.length;
        int[][] c = new int[m+1][n+1];
        for(int i = 0; i <=m; i++)
            c[i][0] = 1;
        for(int i = 1; i <=n; i++)
            c[0][i] = 0;
        for(int i = 1; i <=m; i++)
        {
            for(int j = 100; j <=n; j++)
            {
                if(j < vals[i-1])
                {
                    c[i][j] = c[i-1][j];
                    continue;
                }
                c[i][j] = c[i-1][j] + c[i][j - vals[i-1]];
            }
        }
        return c[m][n];
    }
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            cons[i] = 100+i;
        }
        int x = chargeTypes(cons,c);
        System.out.println(x);
    }
}
