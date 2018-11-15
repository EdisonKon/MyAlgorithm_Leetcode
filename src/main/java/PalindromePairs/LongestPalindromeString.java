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
    /**
     * manacher 算法 70ms
     * 参考   https://segmentfault.com/a/1190000003914228
     *       https://algs4.cs.princeton.edu/53substring/Manacher.java.html
     * */
    public String longestPalindrome3(String s){
        //TODO manacher algorithm 方法
        String ks = "#";
        String[] x = s.split("");
        for (int i = 0; i <x.length; i++) {
            ks+=x[i]+"#";
        }
        int[] rl = new int[ks.length()];
        int maxRight = 0;
        int currentPos = 0;
        int maxLen = 0;
        int maxPos = 0;

        for (int i = 0; i < ks.length(); i++) {
            if(i < maxRight){
                rl[i] = Math.min(rl[2*currentPos-i],maxRight-i);
            }else{
                rl[i] = 1;
            }
            //不是边界并且向左右扩展
            while(i - rl[i] >= 0 && i+rl[i] < ks.length() && ks.charAt(i - rl[i]) == ks.charAt(i + rl[i])){
                rl[i] += 1;
            }
            //更新maxRight 和 currentPos
            if(rl[i]+i-1 > maxRight){
                maxRight = rl[i]+i-1;
                currentPos = i;
            }
            //设置最长回文串的长度
            if(rl[i]>maxLen){
                maxPos = i;
            }
            maxLen = Math.max(maxLen,rl[i]);
        }
        System.out.println(maxPos);

        int start = maxPos/2-(maxLen-1)/2;
        int end = start + maxLen -1;
        return s.substring(start,end);
    }

    /***加#的方法
     * 152 ms
     */
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        String ks = "#";
        String[] x = s.split("");
        for (int i = 0; i <x.length; i++) {
            ks+=x[i]+"#";
        }

        int len = ks.length();
        int maxLen = 1;
        Map<Integer,String> mapKv = new HashMap<>();
        for(int i = 1;i<len;i++){
            int left =i;
            int righ= i;
            while(left > 0 && righ < len-1){
                left = --left;
                righ = ++righ;
                if(ks.charAt(left) == ks.charAt(righ)){
                    if(maxLen < righ-left+1){
                        maxLen = Math.max(maxLen,righ-left+1);
                        mapKv.put(maxLen,ks.substring(left,righ+1));
                    }
                }else{
                    break;
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

    /***
     * AC n^3 从最长的开始找,一直找到1个的情况
     * 572 ms
     */
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
    @Test
    public void TestLongestPalindromeString(){
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome3("abacdbd"));
    }

/**

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

 * */
}
