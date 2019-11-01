package Ints;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2019-10-31 22:18
 * @from: https://leetcode.com/problems/factorial-trailing-zeroes/
 * Given an integer n, return the number of trailing zeroes in n!.

    Example 1:

    Input: 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.
    Example 2:

    Input: 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.

    这道题并没有什么难度，是让求一个数的阶乘末尾0的个数，
也就是要找乘数中 10 的个数，而 10 可分解为2和5，而2的数量又远大于5的数量（比如1到 10 中有2个5，5个2），
那么此题即便为找出5的个数。仍需注意的一点就是，像 25，125，这样的不只含有一个5的数字需要考虑进去
 **/

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(test(7));
        System.out.println(trailingZeroes(25));
    }

    private static int test(int n){
        long cur = 5;
        int result = 0;
        while(cur<=n){
            result += n/cur;
            cur *=5;
        }
        return result;
    }
    public static int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
