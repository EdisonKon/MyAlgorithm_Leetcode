package Integers;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2018-11-21 20:06
 * @from: https://leetcode.com/problems/reverse-integer/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:

    Input: 123
    Output: 321
    Example 2:

    Input: -123
    Output: -321
    Example 3:

    Input: 120
    Output: 21
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

    http://www.cnblogs.com/grandyang/p/4125588.html
 **/

public class ReverseInteger {
    public ReverseInteger() {
    }
/**
 * 思路:因为都是用int型的，如果超出了范围，其除以10的结果就不会跟之前的结果一致，通过这点也可以进行区分，参见代码如下
 * Runtime: 20 ms, faster than 90.26% of Java online submissions for Reverse Integer.
 * */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = res * 10 + x % 10;
            if (t / 10 != res) return 0;
            res = t;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test(){
    }
}
