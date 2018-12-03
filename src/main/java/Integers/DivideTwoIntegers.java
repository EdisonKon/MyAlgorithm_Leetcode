package Integers;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2018-12-03 21:29
 * @from https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 **/
public class DivideTwoIntegers {
    public DivideTwoIntegers() {

    }

    /**
     * leetcode 使用左移，每次*2 左移每次8，4，2，1
     * Runtime: 17 ms, faster than 86.85% of Java online submissions for Divide Two Integers.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor) {
        int sign = divisor > 0 && dividend < 0 || divisor < 0 && dividend > 0 ? -1 : 1;
        long dvdend = Math.abs((long)dividend), dvsr = Math.abs((long)divisor);

        long ret = 0;
        while(dvdend >= dvsr) {
            long res = 1, sum = dvsr;
            while(sum << 1 < dvdend) {
                sum <<= 1;
                res <<= 1;
            }
            ret += res;
            dvdend -= sum;
        }

        if(sign == -1) ret = -ret;
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)ret;
    }

    /**
     * 超时了
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int val = 0;
        boolean fh= false;
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }else if(divisor == 1){
                return dividend;
            }else if(divisor > 0){
                divisor = 0-divisor;
                while(dividend<=divisor){
                    dividend = dividend - divisor;
                    val++;
                }
                return 0 - val;
            }
        }else{
            if(dividend<0 && divisor>0){
                dividend = 0-dividend;
                fh = true;
            }else if(dividend>0 && divisor<0){
                divisor = 0-divisor;
                fh = true;
            }else{
                dividend = Math.abs(dividend);
                divisor = Math.abs(divisor);
            }
        }

        while(dividend>=divisor){
            dividend = dividend - divisor;
            val++;
        }

        val = fh?0-val:val;
        return val;
    }

    @Test
    public void test() {
        //divide(Integer.MAX_VALUE,Integer.MIN_VALUE);
        divide(Integer.MIN_VALUE,1);

    }
}
