package Strings;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Medium
 * @create: 2018-11-21 20:54
 * @from: https://leetcode.com/problems/string-to-integer-atoi/
 * Implement atoi which converts a string to an integer.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
Thefore INT_MIN (−231) is returned.
 **/

public class StringtoInteger {
    public StringtoInteger() {
    }

    /**
     *
     * Runtime: 17 ms, faster than 98.13% of Java online submissions for String to Integer (atoi).
     * @param str
     * @return
     */

    public int myAtoi(String str) {
        str = str.trim();
        boolean isFu = false;
        Long current = 0L;
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if(val == 45 && i ==0){//是-符号
                isFu = true;
            }else if(val == 43 && i ==0){//是+符号
                isFu = false;
            }else if(val> 47 && val < 58){//是数字
                int x = Character.getNumericValue(val);
                current = current*10 + (isFu?0-x:x);
                if(current > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(current < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        return current.intValue();
    }

    @Test
    public void test(){
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("9223372036854775808"));
    }
}
