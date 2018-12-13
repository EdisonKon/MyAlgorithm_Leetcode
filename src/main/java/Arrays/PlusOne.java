package Arrays;

import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-13 16:22
 * @from https://leetcode.com/problems/plus-one/
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

public class PlusOne {
    public PlusOne() {

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int up = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
                up = 1;
            }else{
                    digits[i] = digits[i]+1;
                    up = 0;
                    break;
            }
        }

        if(up == 1){
            int[] d = new int[digits.length+1];
            System.arraycopy(digits,0,d,1,digits.length);
            d[0] = 1;
            return d;
        }
        return digits;
    }

    @Test
    public void test() {
        System.out.println(plusOne(new int[]{4,3,2,1}));
        System.out.println(plusOne(new int[]{9,9,9,9}));
        System.out.println(plusOne(new int[]{2,4,9,3,9}));
    }
}

