package Integers;

import org.junit.Test;

/**
 * @Author dekai.kong
 * @description: 难度 Medium
 * @create: 2018-11-21 20:06
 * @from: https://leetcode.com/problems/integer-to-roman/
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 **/

public class IntegertoRoman {
    public IntegertoRoman() {
    }
    /**
     *挨个处理的方法
     * Runtime: 43 ms, faster than 89.75% of Java online submissions for Integer to Roman.
     * */
    public String intToRoman(int num) {
        if(num > 3999 || num <1){
            return "";
        }
        int curInx = 0;
        String rst = "";
        //处理 千 的情况
        curInx = num/1000;
        for (int i = 0; i < curInx; i++) {
            rst += "M";
        }
        //处理 百 的情况
        curInx = (num%1000/100);
        if(curInx!=0){//不等于0 才计算
            if(curInx < 4){
                for (int i = 0; i < curInx; i++) {
                    rst += "C";
                }
            }else if(curInx == 4){
                rst += "C"+"D";
            }else if(curInx == 5){
                rst += "D";
            }else if(curInx == 6){
                rst += "D"+"C";
            }else if(curInx > 6 && curInx < 9){
                rst += "D";
                for (int i = 5; i < curInx; i++) {
                    rst += "C";
                }
            }else{
                rst += "C" + "M";
            }
        }
        //处理 十 的情况
        curInx = (num%100/10);
        if(curInx!=0){//不等于0 才计算
            if(curInx < 4){
                for (int i = 0; i < curInx; i++) {
                    rst += "X";
                }
            }else if(curInx == 4){
                rst += "X"+"L";
            }else if(curInx == 5){
                rst += "L";
            }else if(curInx == 6){
                rst += "L"+"X";
            }else if(curInx > 6 && curInx < 9){
                rst += "L";
                for (int i = 5; i < curInx; i++) {
                    rst += "X";
                }
            }else{
                rst += "X" + "C";
            }
        }
        //处理 个 的情况
        curInx = num%10;
        if(curInx!=0){//不等于0 才计算
            if(curInx < 4){
                for (int i = 0; i < curInx; i++) {
                    rst += "I";
                }
            }else if(curInx == 4){
                rst += "I"+"V";
            }else if(curInx == 5){
                rst += "V";
            }else if(curInx == 6){
                rst += "V"+"I";
            }else if(curInx > 6 && curInx < 9){
                rst += "V";
                for (int i = 5; i < curInx; i++) {
                    rst += "I";
                }
            }else{
                rst += "I" + "X";
            }
        }

        return rst;
    }

    /**
     *转换 成for处理 精简代码
     *Runtime: 59 ms, faster than 43.26% of Java online submissions for Integer to Roman.
     * */
    public String intToRoman2(int num) {
        if (num > 3999 || num < 1) {
            return "";
        }
        String rst = "";
        int elm = 10;
        int curInx = num;
        int cubit = 1;
        String[] index = {"","I","V","X","L","C","D","M","M"};
        while (elm <= 10000){
            curInx = num%elm/(elm/10);
            elm = elm * 10 ;
            if(curInx!=0){//不等于0 才计算
                if(curInx < 4){
                    for (int i = 0; i < curInx; i++) {
                        rst = index[cubit]+rst;
                    }
                }else if(curInx == 4){
                    rst = index[cubit]+index[cubit+1]+rst;
                }else if(curInx == 5){
                    rst = index[cubit+1]+rst;
                }else if(curInx == 6){
                    rst = index[cubit+1]+index[cubit]+rst;
                }else if(curInx > 6 && curInx < 9){
                    for (int i = 5; i < curInx; i++) {
                        rst = index[cubit]+rst;
                    }
                    rst = index[cubit +1]+rst;
                }else{
                    rst = index[cubit] + index[cubit+2]+rst;
                }
            }
            cubit += 2;
        }
        return rst;
    }
    @Test
    public void test(){
        System.out.println(intToRoman2(58));
//        System.out.println(intToRoman2(1994));
//        System.out.println(intToRoman2(1000));
    }
}
