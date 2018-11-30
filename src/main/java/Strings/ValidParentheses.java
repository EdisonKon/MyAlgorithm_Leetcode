package Strings;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author dekai.kong
 * @description: 难度 Easy
 * @create: 2018-11-21 20:54
 * @from: https://leetcode.com/problems/valid-parentheses/
 *
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

 **/

public class ValidParentheses {
    public ValidParentheses() {
    }

    /**
     *
     * Runtime: 4 ms, faster than 99.52% of Java online submissions for Valid Parentheses.
     * @param s
     * @return true/false
     *
     * 把左边都放到数组中,碰到右边的就进行index的-- 比对,然后碰到左边的再放到数组,再比对
     */

    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int index = 0;
        for(char c : s.toCharArray()) {
            switch (c){
                case '(':
                case '{':
                case '[':
                    arr[index] = c;
                    index++;
                    break;
                case ')':
                    if(index == 0 || arr[--index] != '('){
                        return false;
                    }
                    break;
                case '}':
                    if(index == 0 || arr[--index] != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(index == 0 || arr[--index] != '['){
                        return false;
                    }
                    break;
            }
        }
        return index == 0;
    }

    /**
     * 超屌的leetcode解法
     * 用栈 压入弹出
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("(("));
//        System.out.println(isValid("){"));
//        System.out.println(isValid("{[(])}"));
//        System.out.println(isValid("()"));
        System.out.println(isValid("(([[]]){{}})"));
    }
}
