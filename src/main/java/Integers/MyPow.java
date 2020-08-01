package Integers;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-08-01 21:36
 * @from 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 通过次数113,015提交次数311,876
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MyPow {
    public MyPow() {

    }

    /**
     * 思路: 二分进行相乘
     * 1ms 100%
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x ==0) {
            return x;
        }

        //样例输入太长了
        long times = n;

        if (times<0){
            times*=-1;
        }

        double result = 1;
        double contr = x;
        while (times>0){
            if (times%2==1){
                result *=contr;
            }
            contr *=contr;
            times /=2;
        }

        return n>0?result:1.0/result;
    }


    @Test
    public void test() {
        myPow(2.0,10);
    }
}
