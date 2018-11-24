package Strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dekai.kong
 * @description: 难度 Medium
 * @create: 2018-11-21 20:54
 * @from: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Implement atoi which converts a string to an integer.

Note:
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

九宫格按键

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 **/

public class LetterCombinationsofaPhoneNumber {
    public LetterCombinationsofaPhoneNumber() {
    }

    /**
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
     * @param digits
     * @return
     */

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        List<String> list = new ArrayList<>();
        char[][] r = {
                {},
                {},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        while(digits.length()>0){
            list = getList(list,digits,r);
            digits = digits.substring(0,digits.length()-1);
        }
        return list;
    }
    public List<String> getList(List<String> current,String digits,char[][] r){
        char[] x = r[Character.getNumericValue(digits.charAt(digits.length()-1))];
        List<String> temp = new ArrayList();
        for(int j = 0;j<x.length;j++){
            if(current.size() == 0){
                temp.add(x[j]+"");
            }else{
                for (int k = 0; k < current.size(); k++) {
                    temp.add(x[j]+current.get(k));
                }
            }
        }
        current = temp;
        return current;
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("234"));
    }
}
