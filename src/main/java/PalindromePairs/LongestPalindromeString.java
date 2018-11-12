package PalindromePairs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        Map<Integer,String> mapKv = new HashMap<>();
        for(int i = 1;i<len;i++){
            int left =i;
            int righ= i;
            while(left > 0 && righ < len-1){
                left = --left;
                righ = ++righ;

                if(s.charAt(left) == s.charAt(righ)){
                    if(maxLen <= righ-left+1){
                        maxLen = Math.max(maxLen,righ-left+1);
                        mapKv.put(maxLen,s.substring(left,righ+1));
                    }
                }else if(s.charAt(left) == s.charAt(i)){
                    righ = i;
                    maxLen = Math.max(maxLen,righ-left+1);
                    mapKv.put(maxLen,s.substring(left,righ+1));
                }else{
                    break;
                }
            }
            if(maxLen == len){
                break;
            }
        }
        return mapKv.get(maxLen);
    }

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
//        System.out.println(longestPalindrome("bbbb"));
        System.out.println(longestPalindrome2("babad"));
    }
}
