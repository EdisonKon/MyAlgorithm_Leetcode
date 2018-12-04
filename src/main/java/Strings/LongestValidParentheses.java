package Strings;

import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Hard
 * @create 2018-12-04 21:00
 * @from https://leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 **/
public class LongestValidParentheses {
    public LongestValidParentheses() {

    }

    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int rst = 0;
        int curr = 0;
        int lastindex = Integer.MIN_VALUE;
        int curindex = 0;
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                if(curindex == 0){
                    curindex = i;
                }
                left += 1;
                rs+="(";
                curr = Math.min(left,right);
            }else{
                if(left == right && left ==0 ){
                    left = right = 0;
                    continue;
                }
                right += 1;
                rs+=")";
                curr = Math.min(left,right);
            }

            if(left == right && left!=0){
                rst = Math.max(rst,curr);
                left = right = 0;
                if (lastindex+1 == curindex){
                    rst = Math.max(rst+curr,curr);
                }
                curindex = 0;
                lastindex = i;
            }

            if(left>right && i == s.length()-1){
                curr = Math.min(left,right);
                curindex = i - curr;
                lastindex = i;
            }
//            if (lastindex+1 == curindex){
//                rst = Math.max(rst+curr,curr);
//            }
        }
        rst = Math.max(rst,curr);
        System.out.println(rs);
        return rst*2;
    }

    @Test
    public void test() {
//        longestValidParentheses("(()");
//        longestValidParentheses("()(()");
//        longestValidParentheses(")()())");
//        longestValidParentheses(")((()())");
//        longestValidParentheses(")((())))))");
//        longestValidParentheses(")(()))()");
        longestValidParentheses("()(())");
    }
}
