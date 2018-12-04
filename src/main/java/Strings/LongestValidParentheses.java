package Strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    //)())(())()
    public int longestValidParentheses(String s) {
        int rst = 0;
        int len = 0;
        int left = 0;
        int right = 0;
        Map<Integer,Integer> mapIL = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                if (left==0)left = 1;
            }else{
                if(left == 1)right = 1;
            }
            if(left == right){
                len = 1;
                left = right = 0;
                int j = i-2;//左边的左边
                int k = i+1;//当前位置的右边
                while(j>0 && k<s.length()){
                    if(s.charAt(j)=='(' && s.charAt(k)==')'){
                        len++;
                        j--;
                        k++;
                    }else if(s.charAt(j)==')'){
                        int val = mapIL.getOrDefault(j,-1);
                        if( val != -1){
                            j -= val * 2;
                            len += val;
                        }else{
                            mapIL.put(k,len);
                            break;
                        }
                    }
                }
                mapIL.put(k,len);
            }
        }
        return rst;
    }

    public int longestValidParentheses2(String s) {
        int left = 0;
        int right = 0;
        int rst = 0;
        int curr = 0;
        int newrst = 0;
        int lastindex = Integer.MIN_VALUE;
        int curindex = 0;
        boolean isnew = true;
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
                left = right = 0;
                if (lastindex+1 == curindex){
                    if(!isnew){
                        rst = Math.max(rst+curr,curr);
                    }else{
                        rst = Math.max(newrst+curr,rst);
                        isnew = false;
                    }
                }else{
                    newrst = 0;
                    rst = Math.max(rst,curr);
                    newrst += curr;
                    isnew = true;
                }
                curindex = 0;
                lastindex = i;
            }

//            if(left>right && i == s.length()-1){
//                curr = Math.min(left,right);
//                curindex = i - curr;
//                lastindex = i;
//            }
//            if (lastindex+1 == curindex){
//                rst = Math.max(rst+curr,curr);
//            }
        }
        rst = Math.max(rst,curr);
//        System.out.println(rs);
        System.out.println(rst);
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
//        longestValidParentheses("()(())");
//        longestValidParentheses(")()())()()(");
        longestValidParentheses("(()(((()");
        // 1 1 2 3 3 2 3 2 1
    }
}
