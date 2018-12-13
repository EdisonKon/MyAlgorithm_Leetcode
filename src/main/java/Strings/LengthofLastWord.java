package Strings;

import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-13 10:37
 * @from https://leetcode.com/problems/length-of-last-word/
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */

public class LengthofLastWord {
    public LengthofLastWord() {

    }

    /**
     * Runtime: 3 ms, faster than 85.47% of Java online submissions for Length of Last Word.
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }else{
            String[] sx =s.split(" ");
            return sx[sx.length-1].length();
        }
    }

    @Test
    public void test() {
        System.out.println(lengthOfLastWord("sss    "));
    }
}

