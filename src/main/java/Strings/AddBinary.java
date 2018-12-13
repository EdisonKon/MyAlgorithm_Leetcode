package Strings;

import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-13 17:22
 * @from https://leetcode.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
    public AddBinary() {

    }

    /**
     * Runtime: 2 ms, faster than 97.12% of Java online submissions for Add Binary.
     * 遍历到底
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] ax = a.toCharArray();
        char[] bx = b.toCharArray();
        int up = 0;
        int la = ax.length-1;
        int lb = bx.length-1;
        StringBuilder sb = new StringBuilder();
        while(la>=0||lb>=0){
            int avl = 0;
            int bvl = 0;
            if(la>=0){
                avl = ax[la]=='0' ?0:1;
            }
            if(lb>=0){
                bvl = bx[lb]=='0' ?0:1;;
            }
            if ((avl & bvl) == 1 ){
                sb.insert(0,up);
                up = 1;
            }else if(((avl ^ bvl) & up) == 1){
                sb.insert(0,0);
                up = 1;
            }else{
                sb.insert(0,(avl ^ bvl)+up);
                up = 0;
            }
            la--;
            lb--;
        }
        if (up == 1) {sb.insert(0,1);}
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(addBinary("1010","1011"));
        System.out.println(addBinary("1111","1111"));
        System.out.println(addBinary("11","1"));

    }
}

