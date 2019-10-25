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
    static int[] cons = new int[25];
    static int c = 24;

    public static int chargeTypes(int[] vals, int n){
        int m = vals.length;
        int[][] c = new int[m+1][n+1];
        for(int i = 0; i <=m; i++){
            c[i][0] = 1;
        }
        for(int i = 1; i <=n; i++){
            c[0][i] = 0;
        }
        for(int i = 1; i <=m; i++){
            for(int j = 1; j <=n; j++){
                if(j < vals[i-1]){
                    c[i][j] = c[i-1][j];
                    continue;
                }
                c[i][j] = c[i-1][j] + c[i][j - vals[i-1]];
            }
        }
        return c[m][n];
    }

    /**
     * 标答
     * dp代表由10个数构成24的情况
     * f[0][0]就是由0个数构成0只有1种情况
     * j就是已经加上的总和
     * k就是下一个要选数
     * j+k就是要构成的数比如f[2][j+k] 就是由2个数构成j+k的情况
     * 当j=1 k=23时,就是当前其他数总和是1,选k=23
     * 当j=24 k=1时,就是当前其他数总和是23,选k=1
     * j+k不能大于24
     * 一遍一遍选k保证每个j都选到响应的k
     * 每逢j+k小于24则多一种情况,并汇总f[i+1][j+k]
     */
    public static void test1024(){
        int[][] f = new int[11][25];
        f[0][0] = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 25; k++) {
                    if((j+k)>24){
                        break;
                    }
                    f[i+1][j+k] += f[i][j];
                }
            }
        }
        System.out.println(f[10][24]);
    }

    public static void test1024_2(){
        int[][] f = new int[4][4];
        f[0][0] = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if((j+k)>3){
                        break;
                    }
                    f[i+1][j+k] += f[i][j];
                }
            }
        }
        System.out.println(f[3][3]);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            cons[i] = i;
        }
//        int x = chargeTypes(cons,c);
//        System.out.println(x);

//        test1024();
        test1024_2();
    }
}
