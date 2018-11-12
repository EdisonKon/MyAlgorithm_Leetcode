package PalindromePairs;

import org.junit.Test;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-11-12 16:46
 *
 *
 * 5. Longest Palindromic Substring
 * Medium
 * 2529
 * 241
 *
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */


public class LongestPalindromeString {
    public LongestPalindromeString(){

    }
    //分情况判断方法
    int maxLen = 1;
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        int len = s.length();
        for (int i = 1; i < len; i++) {
            isOddBack(s,i);
            isEvenBack(s,i);
        }
        return s.substring(start,end);
    }
    public void isOddBack(String s,int index){
        int left =index;
        int righ= index;
        while(left >= 1 && righ < (s.length() - 1) && s.charAt(left--) == s.charAt(righ++)){
            if(righ - left >= maxLen){
                maxLen = righ - left;
                start = left;
                end = righ;
            }
        }
    }
    public void isEvenBack(String s,int index){
        int left =index;
        int righ= index;
        while(left >= 1 && righ <= (s.length()-1)  && s.charAt(left) == s.charAt(righ++)){
            if(righ - left >= maxLen){
                maxLen = righ - left;
                start = left;
                end = righ;
            }
        }
    }

//n^3的运行时间,ac了
    public String longestPalindrome2(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        if(s.length() == 0 || s.length() == 1 || isBack(s,left,right)){
            return s;
        }
        for(int i = 1;i<len;i++){
            for(int j = 0;j<=i;j++){
                String rs = s.substring(j,len-i+j);
                if(isBack(rs,0,rs.length()-1)){
                    return rs;
                }
            }
        }
        return "";
    }
    public boolean isBack(String s,int left,int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    @Test
    public void TestLongestPalindromeString(){
        System.out.println(longestPalindrome("bbbb"));
//        System.out.println(longestPalindrome2("babad"));
    }
}
