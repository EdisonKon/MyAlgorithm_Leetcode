package Integers;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2018-11-21 21:34
 * @from: https://leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    Example 1:

    Input: 121
    Output: true
    Example 2:

    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Follow up:

    Coud you solve it without converting the integer to a string?
    直接做不用字符串转换
 **/

public class PalindromeNumber {

    public PalindromeNumber() {
    }
    /**
     * 这是全部判断
     * Runtime: 83 ms, faster than 95.72% of Java online submissions for Palindrome Number.
     */
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10 ==0 && x !=0)){//如果是负数或者最低位是0(因为最高位肯定不能得0)且x不是0,那肯定不是回文
            return false;
        }else{
            int temp = 0;
            int thx = x;

            while(x /10 >0 || x %10 >0){
                temp = temp*10 + x%10;
                x = x/10;
            }
            if(temp == thx){
                return true;
            }
        }
        return  false;
    }
    /**
    //还可以使用一半判断,需要判断奇数偶数个.
    // 当走到一半的时候,如果是回文,那么偶数个位的情况就是x = temp
    // 当走到一半的时候,如果是回文,那么奇数个位的情况就是temp/10 = x 把中间的那个数去掉
     Runtime: 73 ms, faster than 99.97% of Java online submissions for Palindrome Number.
    */
    public boolean isPalindrome2(int x) {
        if(x<0 || (x%10 ==0 && x !=0)){//如果是负数或者最低位是0(因为最高位肯定不能得0)且x不是0,那肯定不是回文
            return false;
        }else{
            int temp = 0;
            while(x> temp){
                temp = temp*10 + x%10;
                x = x/10;
            }
            if(temp == x || temp/10 == x){
                return true;
            }
        }
        return  false;
    }
    @Test
    public void test(){
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome2(1));
    }
}
